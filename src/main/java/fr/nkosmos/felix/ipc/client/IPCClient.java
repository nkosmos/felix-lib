package fr.nkosmos.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.net.IPCConnectionManager;
import fr.nkosmos.felix.ipc.client.net.IPCPipeline;
import lombok.Data;
import lombok.SneakyThrows;

public @Data class IPCClient {

    private final IPCConnectionManager connectionManager;
    private final IPCPipeline pipeline = new IPCPipeline(this);

    @SneakyThrows
    public void start() {
        this.connectionManager.start();
    }

    @SneakyThrows
    public void shutdown() {
        this.connectionManager.shutdown();
    }

}
