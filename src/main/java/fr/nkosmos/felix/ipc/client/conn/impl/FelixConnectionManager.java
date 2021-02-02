package fr.nkosmos.felix.ipc.client.conn.impl;

import fr.nkosmos.felix.ipc.client.conn.IConnectionManager;
import org.scalasbt.ipcsocket.UnixDomainSocket;
import org.scalasbt.ipcsocket.Win32NamedPipeSocket;

import java.io.IOException;
import java.net.Socket;

public class FelixConnectionManager implements IConnectionManager {

    final boolean isWin = System.getProperty("os.name", "").toLowerCase().startsWith("win");

    @Override
    public Socket provideConnection(String socketName) throws IOException {
        return isWin
                ? new Win32NamedPipeSocket(socketName, true)
                : new UnixDomainSocket(socketName, true);
    }
}
