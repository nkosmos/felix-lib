package fr.nkosmos.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.net.ClientConnectionManager;
import fr.nkosmos.felix.ipc.client.net.ClientPipeline;
import fr.nkosmos.felix.ipc.common.util.auth.IAuthenticationProfile;
import lombok.Data;
import lombok.SneakyThrows;

public @Data class IPCClient {

    private final ClientConnectionManager connectionManager = new ClientConnectionManager();
    private final ClientPipeline pipeline = new ClientPipeline(this);

    private final IAuthenticationProfile authenticationProfile;

    public void start() {
        if(authenticationProfile == null) throw new UnsupportedOperationException("Please define authenticationProfile");
        _start();
    }

    @SneakyThrows
    private void _start(){
        this.connectionManager.start();

        this.pipeline.start();
    }

    @SneakyThrows
    public void shutdown() {
        this.connectionManager.shutdown();
    }

}
