package fr.nkosmos.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.net.IPCConnectionManager;
import fr.nkosmos.felix.ipc.client.net.IPCPipeline;
import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;

public @Data class IPCClient {

    private final IPCConnectionManager connectionManager;
    private final IPCPipeline pipeline;

    @SneakyThrows
    public void start() {
        this.connectionManager.start();
        this.pipeline.identify();
    }

    @SneakyThrows
    public void shutdown() {
        this.pipeline.shutdown();
        this.connectionManager.shutdown();
    }

}
