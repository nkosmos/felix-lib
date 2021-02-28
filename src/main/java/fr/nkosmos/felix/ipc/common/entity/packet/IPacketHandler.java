package fr.nkosmos.felix.ipc.common.entity.packet;

import fr.nkosmos.felix.ipc.common.entity.ISerializable;

public interface IPacketHandler<T extends ISerializable, K extends ISerializable> {

    K handleClient(T packet);

    K handleServer(T packet);

}
