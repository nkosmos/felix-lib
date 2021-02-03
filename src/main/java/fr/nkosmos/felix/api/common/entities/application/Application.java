package fr.nkosmos.felix.api.common.entities.application;

import lombok.Data;

import java.net.URL;
import java.util.UUID;

/**
 * Entity representation of any Kosmos Application
 * 
 * @author xTrM_
 */
public @Data class Application {
    
    private final String name, version;
    private final UUID uuid;
    private final UUID[] authors;
    private final URL bundleURL;
    private final boolean available;
    
}
