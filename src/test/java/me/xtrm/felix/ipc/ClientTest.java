package me.xtrm.felix.ipc;

import fr.nkosmos.felix.ipc.client.IPCClient;
import fr.nkosmos.felix.ipc.client.net.IPCConnectionManager;

import java.io.IOException;
import java.util.UUID;

public class ClientTest {

    public static void main(String[] args) throws IOException {
        IPCConnectionManager connectionManager = new IPCConnectionManager();
        connectionManager.start();
    }

}
