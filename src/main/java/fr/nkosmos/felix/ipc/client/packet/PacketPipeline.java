package fr.nkosmos.felix.ipc.client.packet;

import fr.nkosmos.felix.ipc.client.FelixIPCClient;
import lombok.Data;

public @Data class PacketPipeline {

    private final FelixIPCClient client;
    private final String clientKey;

    public void identify(){

    }

    public void shutdown(){

    }

}