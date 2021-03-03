package fr.nkosmos.felix.api.common.entities.application;

import java.net.URL;
import java.util.UUID;

public interface IApplication {

    String getName();

    UUID getUuid();

    String getVersion();

    UUID getAuthorId();

    String getIcon();

    String getDescription();

    URL getDataUrl();

    boolean isAvailable();

    boolean requiresSubscription();

    UUID getPricingId();



}
