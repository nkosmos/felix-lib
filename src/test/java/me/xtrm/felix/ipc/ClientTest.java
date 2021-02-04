package me.xtrm.felix.ipc;

import fr.nkosmos.felix.ipc.client.IPCClient;

import java.util.UUID;

public class ClientTest {

    public static void main(String[] args){
        IPCClient client = IPCClient.newInstance(UUID.randomUUID().toString());
        client.start();
    }

}
