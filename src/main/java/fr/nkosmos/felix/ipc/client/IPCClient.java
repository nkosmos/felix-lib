package fr.nkosmos.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.net.IPCConnectionManager;
import fr.nkosmos.felix.ipc.client.net.IPCPipeline;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class IPCClient {

    public static IPCClient newInstance(String clientKey){
        return new IPCClient(clientKey);
    }

    private final IPCConnectionManager connectionManager;
    private final IPCPipeline pipeline;

    IPCClient(String clientKey) {
        this.connectionManager = new IPCConnectionManager();
        this.pipeline = new IPCPipeline(this, clientKey);
    }

    @SneakyThrows
    public void start(){
        this.connectionManager.start();
        this.pipeline.identify();
    }

    @SneakyThrows
    public void shutdown(){
        this.pipeline.shutdown();
        this.connectionManager.shutdown();
    }

}
