package fr.nkosmos.felix.ipc.client.net;

import fr.nkosmos.felix.ipc.client.IPCClient;
import fr.nkosmos.felix.ipc.common.entity.ISerializable;
import fr.nkosmos.felix.ipc.common.entity.packet.IPacketHandler;
import fr.nkosmos.felix.ipc.common.entity.packet.PacketSerializer;
import fr.nkosmos.felix.ipc.common.entity.packet.impl.PacketHeartbeat;
import lombok.Data;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public @Data class IPCPipeline {

    private final IPCClient client;
    private final PacketSerializer serializer = new PacketSerializer();

    private final Map<IPacketHandler<? extends ISerializable, ? extends ISerializable>, Class<? extends ISerializable>> handlerList = new HashMap<>();
    private final Queue<ISerializable> packetQueue = new ConcurrentLinkedQueue<>();

    public void start() {
        Thread dispatcherThread = new Thread("IPC-Dispatcher"){
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                boolean lastState = false;
                while(!this.isInterrupted()){
                    long currentTime = System.currentTimeMillis();
                    if(currentTime - time >= 500){
                        time = currentTime;
                        lastState ^= true;

                        if(lastState){
                            packetQueue.add(new PacketHeartbeat(UUID.randomUUID()));
                        }

                        if(packetQueue.isEmpty()) return;

                        ISerializable serializable = packetQueue.poll();
                        sendPacket(serializable);
                    }
                }
            }
        };
        dispatcherThread.setDaemon(true);
        dispatcherThread.start();
    }

    @SneakyThrows
    public <T extends ISerializable, K extends ISerializable> void queuePacket(T packet) {
        packetQueue.add(packet);
    }

    @SneakyThrows
    private <T extends ISerializable, K extends ISerializable> void sendPacket(T packet){
        ByteBuffer buffer = serializer.write(packet);

        ByteBuffer recieved = client.getConnectionManager().send(buffer);

        ISerializable recievedPacket = serializer.read(recieved);
        if(recievedPacket == null) return;

        List<IPacketHandler> list = handlerList.keySet().stream().filter(k -> handlerList.get(k).equals(recievedPacket.getClass())).collect(Collectors.toList());
        list.forEach(h -> {
            ISerializable newPacket = h.handleClient(recievedPacket);
            if(newPacket != null){
                queuePacket(newPacket);
            }
        });
    }

    public <T extends ISerializable, K extends ISerializable> void registerHandler(IPacketHandler<T, K> handler, Class<T> clazz){
        this.handlerList.put(handler, clazz);
    }
}