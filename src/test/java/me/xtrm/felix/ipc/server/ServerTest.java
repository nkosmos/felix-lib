package me.xtrm.felix.ipc.server;

import org.scalasbt.ipcsocket.UnixDomainServerSocket;
import org.scalasbt.ipcsocket.Win32NamedPipeServerSocket;
import org.scalasbt.ipcsocket.Win32SecurityLevel;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServerTest {

    static final boolean isWin = System.getProperty("os.name", "").toLowerCase().startsWith("win");

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer(newServerSocket(getSocketName()));
        server.run();
    }

    private static String getSocketName() throws IOException {
        if(isWin) {
            return "\\\\.\\pipe\\libfelixipc";
        } else {
            String uid = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
            Path tempDir = Files.createTempDirectory("libfelix");
            Path socketPath = tempDir.resolve("ipc" + uid + ".sock");
            return socketPath.toString();
        }
    }

    static ServerSocket newServerSocket(String sock) throws IOException {
        System.out.println(sock);
        return isWin
                ? new Win32NamedPipeServerSocket(sock, true, Win32SecurityLevel.LOGON_DACL)
                : new UnixDomainServerSocket(sock, true);
    }

}
