package me.xtrm.felix.ipc.server;

import fr.nkosmos.felix.ipc.common.net.IPipeline;
import fr.nkosmos.felix.ipc.common.net.ISerializable;
import fr.nkosmos.felix.ipc.common.net.packet.PacketProcessor;
import fr.nkosmos.felix.ipc.common.net.packet.PacketSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

public class SimpleServer {

    private static final PacketSerializer serializer = new PacketSerializer();

    private final ServerSocket serverSocket;

    public SimpleServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            CompletableFuture.supplyAsync(() -> handleClient(clientSocket));
        }
    }

    private boolean handleClient(Socket clientSocket){
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            InputStream inputStream = clientSocket.getInputStream();

            byte[] payload = new byte[0x8000];

            IPipeline pipeline = new IPipeline() {
                @Override
                public <T extends ISerializable> void queuePacket(T packet) {
                    try {
                        sendPacket(packet);
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                }

                private <T extends ISerializable> void sendPacket(T packet) throws IOException {
                    ByteBuffer buf = serializer.write(packet);
                    outputStream.write(buf.array());
                    outputStream.write("\n".getBytes());
                    outputStream.flush();
                }
            };
            PacketProcessor processor = new PacketProcessor(pipeline, true);

            while(true){
                inputStream.read(payload);
                ByteBuffer buffer = ByteBuffer.wrap(payload);
                ISerializable ser = serializer.read(buffer);
                if(ser == null) continue;
                processor.handle(ser);
            }
        } catch(Throwable ignored) {
        }
        return true;
    }

}
