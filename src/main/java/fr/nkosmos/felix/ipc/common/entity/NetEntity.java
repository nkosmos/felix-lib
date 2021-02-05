package fr.nkosmos.felix.ipc.common.entity;

import java.nio.ByteBuffer;

public interface NetEntity {

    void read(ByteBuffer buffer);

    void write(ByteBuffer buffer);

}
