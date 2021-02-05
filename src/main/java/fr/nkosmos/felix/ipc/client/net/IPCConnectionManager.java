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

public class IPCConnectionManager {

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

    public ByteBuffer send(byte[] arr) throws IOException {
        this.outputStream.write(arr);
        this.outputStream.write("\n".getBytes());
        this.outputStream.flush();

        byte[] bytearr = new byte[0x200000];
        this.inputStream.read(bytearr, 0, 0);

        return ByteBuffer.wrap(bytearr);
    }

    public void shutdown() throws IOException {
        socket.close();
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
