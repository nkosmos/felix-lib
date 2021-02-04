package fr.nkosmos.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.conn.IPCConnectionManager;
import fr.nkosmos.felix.ipc.client.packet.PacketPipeline;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class FelixIPCClient {

    public static FelixIPCClient newInstance(String clientKey){
        return new FelixIPCClient(clientKey);
    }

    private final IPCConnectionManager connectionManager;
    private final PacketPipeline pipeline;

    FelixIPCClient(String clientKey) {
        this.connectionManager = new IPCConnectionManager();
        this.pipeline = new PacketPipeline(this, clientKey);
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
