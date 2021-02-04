package fr.nkosmos.felix.ipc.common.util;

import java.nio.ByteBuffer;

public class BufferUtil {

    public static void writeString(ByteBuffer buf, String string){
        byte[] stringBytes = string.getBytes();
        buf.putInt(stringBytes.length);
        buf.put(stringBytes);
    }

    public static String readString(ByteBuffer buf){
        int len = buf.getInt();
        byte[] stringBytes = new byte[len];
        buf.get(stringBytes);
        return new String(stringBytes);
    }

}
