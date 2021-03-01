package fr.nkosmos.felix.ipc.common.net;

public interface IPipeline {

    <T extends ISerializable> void queuePacket(T packet);

}
