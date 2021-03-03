package fr.nkosmos.felix.api.common.entities.application.impl;

import fr.nkosmos.felix.api.common.entities.application.IApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.net.URL;
import java.util.UUID;

/**
 * Entity representation of any Kosmos Application
 * 
 * @author xTrM_
 */
@AllArgsConstructor
@NoArgsConstructor
public @Data class Application implements IApplication {
    
    private String name;
    private UUID uuid;
    private String version;
    private UUID authorId;
    private String icon, description;
    private URL dataUrl;
    private boolean available;
    @Accessors(fluent = true) private boolean requiresSubscription;
    private UUID pricingId;

}
