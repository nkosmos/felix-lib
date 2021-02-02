package fr.nkosmos.felix.ipc.client.conn;

import java.io.IOException;
import java.net.Socket;

public interface IConnectionManager {

    Socket provideConnection(String socketName) throws IOException;

}
