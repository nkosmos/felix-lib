package fr.nkosmos.felix.ipc.client.net;

import fr.nkosmos.felix.ipc.client.IPCClient;
import lombok.Data;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;

public @Data class IPCPipeline {

    private final IPCClient client;
    private final String clientKey;

    @SneakyThrows
    public void identify(){

        ByteBuffer bf = ByteBuffer.allocate(0x200000);

        byte[] arr = bf.array();

        ByteBuffer buf = client.getConnectionManager().send(arr);

        byte[] bytearr = buf.array();

        for(byte b : bytearr){
            if(b != 0x00){
                System.out.println(b);
            }
        }
    }

    public void shutdown(){

    }

}