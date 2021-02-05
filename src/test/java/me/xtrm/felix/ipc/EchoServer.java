package me.xtrm.felix.ipc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

public class EchoServer {
    private final ServerSocket serverSocket;

    public EchoServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            CompletableFuture.supplyAsync(
                    () -> {
                        try {
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            String line;
                            do {
                                line = in.readLine();
                                if (line != null) {
                                    System.out.println("server: " + line);
                                    out.print(line + "\n");
                                    out.flush();
                                }
                            } while (!(line != null && line.trim().equals("bye")));
                        } catch (IOException ignored) {
                        }
                        return true;
                    });
        }
    }
}