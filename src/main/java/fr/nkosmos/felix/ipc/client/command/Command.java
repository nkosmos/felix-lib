package fr.nkosmos.felix.ipc.client.command;

public interface Command<T> {

    String getName();
    String[] getArguments();

}
