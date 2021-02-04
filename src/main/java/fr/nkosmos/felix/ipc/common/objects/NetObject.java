package fr.nkosmos.felix.ipc.common.objects;

import java.nio.ByteBuffer;

public interface NetObject {

    void read(ByteBuffer buffer);

    void write(ByteBuffer buffer);

}
