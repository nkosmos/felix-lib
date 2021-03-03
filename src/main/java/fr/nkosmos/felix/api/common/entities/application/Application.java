package fr.nkosmos.felix.api.common.entities.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.UUID;

/**
 * Entity representation of any Kosmos Application
 * 
 * @author xTrM_
 */
@AllArgsConstructor
@NoArgsConstructor
public @Data class Application {
    
    private String name, version;
    private UUID uuid;
    private String image, desc;
    private UUID[] authors;
    private URL data;
}
