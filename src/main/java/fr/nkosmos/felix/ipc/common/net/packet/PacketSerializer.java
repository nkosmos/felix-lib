package fr.nkosmos.felix.ipc.common.net.packet;

import fr.nkosmos.felix.ipc.common.net.ISerializable;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;

public final class PacketSerializer {

    @SneakyThrows
    public final <T extends ISerializable> T read(ByteBuffer buffer){
        int len = buffer.getInt();
        if(len == -1) return null;

        byte[] stringBytes = new byte[len];
        buffer.get(stringBytes);
        String cla$$ = new String(stringBytes);

        System.out.println("[Serializer] Read " + cla$$);

        Class<T> clazz = (Class<T>) Class.forName(cla$$, false, getClass().getClassLoader());
        T instance = clazz.getConstructor().newInstance();
        instance.read(buffer);
        return instance;
    }

    public final <T extends ISerializable> ByteBuffer write(T packet){
        ByteBuffer buffer = ByteBuffer.allocate(0x8000);

        if(packet == null){
            buffer.putInt(-1);
            return buffer;
        }

        String cla$$ = packet.getClass().getName();

        System.out.println("[Serializer] Wrote " + cla$$);

        BufferUtil.writeString(buffer, cla$$);
        packet.write(buffer);
        return buffer;
    }
}
