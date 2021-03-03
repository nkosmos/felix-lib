package fr.nkosmos.felix.ipc.client.net;

import fr.nkosmos.felix.ipc.client.IPCClient;
import fr.nkosmos.felix.ipc.common.net.IPipeline;
import fr.nkosmos.felix.ipc.common.net.ISerializable;
import fr.nkosmos.felix.ipc.common.net.packet.PacketProcessor;
import fr.nkosmos.felix.ipc.common.net.packet.PacketSerializer;
import fr.nkosmos.felix.ipc.common.net.packet.impl.PacketHeartbeat;
import lombok.Data;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final @Data class ClientPipeline implements IPipeline {

    private final IPCClient client;

    private final PacketSerializer serializer = new PacketSerializer();
    private final PacketProcessor processor = new PacketProcessor(this, false);

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
    public <T extends ISerializable> void queuePacket(T packet) {
        packetQueue.add(packet);
    }

    @SneakyThrows
    private <T extends ISerializable> void sendPacket(T packet){
        ByteBuffer buffer = serializer.write(packet);

        ByteBuffer recieved = client.getConnectionManager().send(buffer);

        ISerializable recievedPacket = serializer.read(recieved);
        if(recievedPacket == null) return;

        processor.handle(recievedPacket);
    }
}