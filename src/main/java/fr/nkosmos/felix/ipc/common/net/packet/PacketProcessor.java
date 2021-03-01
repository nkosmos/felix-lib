package fr.nkosmos.felix.ipc.common.net.packet;

import fr.nkosmos.felix.ipc.common.net.IPipeline;
import fr.nkosmos.felix.ipc.common.net.ISerializable;
import fr.nkosmos.felix.ipc.common.net.packet.impl.PacketHeartbeat;
import lombok.SneakyThrows;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class PacketProcessor {

    private final Map<IPacketHandler<? extends ISerializable, ? extends ISerializable>, Class<? extends ISerializable>> handlerList = new HashMap<>();

    private final IPipeline pipeline;
    private final boolean server;

    public PacketProcessor(IPipeline pipeline, boolean server){
        this.pipeline = pipeline;
        this.server = server;

        registerDefaults();
    }

    private void registerDefaults() {
        registerHandler(PacketHeartbeat.class, PacketHeartbeat.Handler.class);
    }

    @SneakyThrows
    public final <T extends ISerializable, K extends IPacketHandler<T, ? extends ISerializable>> void registerHandler(Class<T> packet, Class<K> handler) {
        this.handlerList.put(handler.getConstructor().newInstance(), packet);
    }

    @Nonnull
    private <T extends ISerializable> List<IPacketHandler> getHandlers(Class<T> packetClazz) {
        return handlerList.keySet().stream().filter(k -> handlerList.get(k).equals(packetClazz)).collect(Collectors.toList());
    }

    public void handle(ISerializable packet){
        List<IPacketHandler> handlerList = getHandlers(packet.getClass());
        if(server){
            handlerList.forEach(h -> {
                ISerializable response = h.handleServer(packet);
                if(response == null) return;
                pipeline.queuePacket(response);
            });
        }else{
            handlerList.forEach(h -> {
                ISerializable response = h.handleClient(packet);
                if(response == null) return;
                pipeline.queuePacket(response);
            });
        }
    }
}
