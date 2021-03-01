package fr.nkosmos.felix.ipc.common.net;

import java.nio.ByteBuffer;

public interface ISerializable {

    void read(ByteBuffer buffer);

    void write(ByteBuffer buffer);

}
