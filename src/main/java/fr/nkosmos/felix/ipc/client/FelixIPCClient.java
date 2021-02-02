package fr.nkosmos.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.conn.IConnectionManager;
import lombok.Data;

public @Data class FelixIPCClient {

    private final IConnectionManager connectionManager;



}
