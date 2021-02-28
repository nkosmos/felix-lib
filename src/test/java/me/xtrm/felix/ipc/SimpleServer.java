package me.xtrm.felix.ipc;

import fr.nkosmos.felix.ipc.common.entity.ISerializable;
import fr.nkosmos.felix.ipc.common.entity.packet.PacketSerializer;

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
            inputStream.read(payload);

            ByteBuffer buffer = ByteBuffer.wrap(payload);
            ISerializable ser = serializer.read(buffer);

        } catch(Throwable ignored) {
        }
        return true;
    }
}
