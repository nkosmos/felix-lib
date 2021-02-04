package fr.nkosmos.felix.api.common.entities.application;

import fr.nkosmos.felix.ipc.common.objects.NetObject;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Entity representation of any Kosmos Application
 * 
 * @author xTrM_
 */
@AllArgsConstructor
public @Data class Application implements NetObject {
    
    private String name, version;
    private UUID uuid;
    private UUID[] authors;
    private URL bundleURL;
    private boolean available;

    @SneakyThrows
    @Override
    public void read(ByteBuffer buffer) {
        this.name = BufferUtil.readString(buffer);
        this.version = BufferUtil.readString(buffer);
        this.uuid = UUID.fromString(BufferUtil.readString(buffer));

        int len = buffer.getInt();
        this.authors = new UUID[len];
        for(int i = 0; i < len; i++){
            this.authors[i] = UUID.fromString(BufferUtil.readString(buffer));
        }

        this.bundleURL = new URL(BufferUtil.readString(buffer));
        this.available = buffer.get() != 0;
    }

    @Override
    public void write(ByteBuffer buffer) {
        BufferUtil.writeString(buffer, name);
        BufferUtil.writeString(buffer, version);
        BufferUtil.writeString(buffer, uuid.toString());

        buffer.putInt(this.authors.length);
        for(UUID uuid : authors){
            BufferUtil.writeString(buffer, uuid.toString());
        }

        BufferUtil.writeString(buffer, bundleURL.toString());
        buffer.put(this.available ? (byte)1 : (byte)0);
    }
}
