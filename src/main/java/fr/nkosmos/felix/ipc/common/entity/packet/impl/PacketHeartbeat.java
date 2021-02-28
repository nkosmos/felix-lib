package fr.nkosmos.felix.ipc.common.entity.packet.impl;

import fr.nkosmos.felix.ipc.common.entity.ISerializable;
import fr.nkosmos.felix.ipc.common.entity.packet.IPacketHandler;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.ByteBuffer;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class PacketHeartbeat implements ISerializable {

    private UUID uuid;

    @Override
    public void read(ByteBuffer buffer) {
        this.uuid = UUID.fromString(BufferUtil.readString(buffer));
    }

    @Override
    public void write(ByteBuffer buffer) {
        BufferUtil.writeString(buffer, uuid.toString());
    }

    public static class Handler implements IPacketHandler<PacketHeartbeat, ISerializable>{

        @Override
        public ISerializable handleClient(PacketHeartbeat packet) {
            return null;
        }

        @Override
        public ISerializable handleServer(PacketHeartbeat packet) {
            return packet;
        }
    }
}
