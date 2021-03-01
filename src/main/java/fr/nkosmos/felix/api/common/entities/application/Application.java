package fr.nkosmos.felix.api.common.entities.application;

import fr.nkosmos.felix.ipc.common.net.ISerializable;
import fr.nkosmos.felix.ipc.common.util.BufferUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.net.URL;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Entity representation of any Kosmos Application
 * 
 * @author xTrM_
 */
@AllArgsConstructor
@NoArgsConstructor
public @Data class Application implements ISerializable {
    
    private String name, version;
    private UUID uuid;
    private UUID[] authors;
    private URL data;

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

        this.data = new URL(BufferUtil.readString(buffer));
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

        BufferUtil.writeString(buffer, data.toString());
    }

    public static class LocalApplication extends Application {}
}
