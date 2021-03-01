package fr.nkosmos.felix.ipc.common.net.packet;

import fr.nkosmos.felix.ipc.common.net.ISerializable;

public interface IPacketHandler<T extends ISerializable, K extends ISerializable> {

    K handleClient(T packet);

    K handleServer(T packet);

}
