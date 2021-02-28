package fr.nkosmos.felix.ipc.common.entity.packet.impl;

import fr.nkosmos.felix.ipc.common.entity.ISerializable;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;
import lombok.AllArgsConstructor;

import java.nio.ByteBuffer;

@AllArgsConstructor
public class PacketHandshake implements ISerializable {

    private String name;

    @Override
    public void read(ByteBuffer buffer) {
        this.name = BufferUtil.readString(buffer);
    }

    @Override
    public void write(ByteBuffer buffer) {
        BufferUtil.writeString(buffer, this.name);
    }
}
