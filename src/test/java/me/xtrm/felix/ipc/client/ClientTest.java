package me.xtrm.felix.ipc.client;

import fr.nkosmos.felix.ipc.client.IPCClient;
import fr.nkosmos.felix.ipc.common.util.auth.IAuthenticationProfile;

import java.util.UUID;

public class ClientTest {

    public static void main(String[] args) {
        IPCClient client = new IPCClient(new IAuthenticationProfile() {
            @Override
            public String getTitle() { return "Test Application"; }

            @Override
            public String getVersion() {
                return "4.1.2-INDEV";
            }

            @Override
            public UUID getVendor() {
                return UUID.randomUUID();
            }
        });
        client.start();
    }

}
