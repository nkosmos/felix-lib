package fr.nkosmos.felix.ipc.client.net;

import lombok.SneakyThrows;
import org.scalasbt.ipcsocket.UnixDomainSocket;
import org.scalasbt.ipcsocket.Win32NamedPipeSocket;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientConnectionManager {

    private static final boolean isWin = System.getProperty("os.name", "").toLowerCase().startsWith("win");
    private static final String socketName = getSocketName();

    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public void start() throws IOException {
        this.socket = getOrCreateConnection();
        this.outputStream = this.socket.getOutputStream();
        this.inputStream = this.socket.getInputStream();
    }

    public ByteBuffer send(ByteBuffer buf) throws IOException {
        this.outputStream.write(buf.array());
        this.outputStream.write("\n".getBytes());
        this.outputStream.flush();

        byte[] bytearr = new byte[0x8000];
        this.inputStream.read(bytearr);

        return ByteBuffer.wrap(bytearr);
    }

    public void shutdown() throws IOException {
        this.socket.close();
    }

    private Socket getOrCreateConnection() throws IOException {
        return isWin
                ? new Win32NamedPipeSocket(socketName, true)
                : new UnixDomainSocket(socketName, true);
    }

    @SneakyThrows
    private static String getSocketName(){
        if(isWin) {
            return "\\\\.\\pipe\\libfelixipc";
        } else {
            String uid = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
            Path tempDir = Files.createTempDirectory("libfelix");
            Path socketPath = tempDir.resolve("ipc" + uid + ".sock");
            return socketPath.toString();
        }
    }

}
