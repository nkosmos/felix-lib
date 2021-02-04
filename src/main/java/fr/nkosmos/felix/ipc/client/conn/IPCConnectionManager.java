package fr.nkosmos.felix.ipc.client.conn;

import org.scalasbt.ipcsocket.UnixDomainSocket;
import org.scalasbt.ipcsocket.Win32NamedPipeSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class IPCConnectionManager {

    private static final boolean isWin = System.getProperty("os.name", "").toLowerCase().startsWith("win");
    private static final String socketName = "felix-ipc";

    private Socket socket;
    private BufferedOutputStream outputStream;
    private BufferedInputStream inputStream;

    public void start() throws IOException {
        this.socket = getOrCreateConnection();
        this.outputStream = new BufferedOutputStream(this.socket.getOutputStream());
        this.inputStream = new BufferedInputStream(this.socket.getInputStream());
    }

    public ByteBuffer send(ByteBuffer buffer) throws IOException {
        this.outputStream.write(buffer.array());
        this.outputStream.flush();

        byte[] bytearr = new byte[2048];
        this.inputStream.read(bytearr, 0, 0);

        return ByteBuffer.wrap(bytearr);
    }

    final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public void shutdown() throws IOException {
        socket.close();
    }

    private Socket getOrCreateConnection() throws IOException {
        return isWin
                ? new Win32NamedPipeSocket(socketName, true)
                : new UnixDomainSocket(socketName, true);
    }

}
