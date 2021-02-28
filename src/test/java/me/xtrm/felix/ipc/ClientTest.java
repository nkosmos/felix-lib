package me.xtrm.felix.ipc;

import fr.nkosmos.felix.ipc.client.net.IPCConnectionManager;
import fr.nkosmos.felix.ipc.common.entity.packet.impl.PacketHandshake;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ClientTest {

    public static void main(String[] args) throws IOException {
        IPCConnectionManager connectionManager = new IPCConnectionManager();
        connectionManager.start();
        PacketHandshake p = new PacketHandshake("Suce ma bite");
        ByteBuffer buf = ByteBuffer.allocate(0x200000);
        p.write(buf);
        ByteBuffer buf_out = connectionManager.send(buf);
        String lmao = BufferUtil.readString(buf_out);
        System.out.println(lmao);
    }

}
