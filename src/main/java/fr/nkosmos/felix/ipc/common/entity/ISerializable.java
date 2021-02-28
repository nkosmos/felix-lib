package fr.nkosmos.felix.ipc.common.entity;

import java.nio.ByteBuffer;

public interface ISerializable {

    void read(ByteBuffer buffer);

    void write(ByteBuffer buffer);

}
