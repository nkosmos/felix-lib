package fr.nkosmos.felix.ipc.common.util.auth;

import java.util.Map;
import java.util.UUID;

public interface IAuthenticationProfile {

    String getTitle();

    String getVersion();

    UUID getVendor();

    default Map.Entry<String, Object>[] getData(){
        return new Map.Entry[0];
    }

    default Map.Entry<String, Object> pair(String key, Object value){
        Object _value = value;
        return new Map.Entry<String, Object>() {
            private Object value = _value;

            @Override
            public String getKey() { return key; }

            @Override
            public Object getValue() { return value; }

            @Override
            public Object setValue(Object value) {
                return this.value = value;
            }
        };
    }
}
