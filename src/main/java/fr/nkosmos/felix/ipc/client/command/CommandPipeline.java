package fr.nkosmos.felix.ipc.client.command;

import lombok.Data;

public abstract @Data class CommandPipeline {

    private final String applicationKey;

    public abstract <T> T execute(Command<T> command);

}
