package fr.nkosmos.felix.ipc.common.entity.packet;

import fr.nkosmos.felix.ipc.common.entity.ISerializable;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;

public class PacketSerializer {

    @SneakyThrows
    public <T extends ISerializable> T read(ByteBuffer buffer){
        int len = buffer.getInt();
        if(len == -1) return null;

        byte[] stringBytes = new byte[len];
        buffer.get(stringBytes);
        String cla$$ = new String(stringBytes);

        Class<T> clazz = (Class<T>) Class.forName(cla$$, false, getClass().getClassLoader());
        T instance = clazz.getConstructor().newInstance();
        instance.read(buffer);
        return instance;
    }

    public <T extends ISerializable> ByteBuffer write(T packet){
        ByteBuffer buffer = ByteBuffer.allocate(0x8000);

        if(packet == null){
            buffer.putInt(-1);
            return buffer;
        }

        String className = packet.getClass().getName();
        BufferUtil.writeString(buffer, className);
        packet.write(buffer);
        return buffer;
    }
}
