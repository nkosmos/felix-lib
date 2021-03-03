package fr.nkosmos.felix.api.common.entities.application;

import java.util.UUID;

public interface IApplication {

    String getName();

    UUID getUuid();

    String getVersion();

    UUID getAuthorId();

    String getIcon();

    String getDescription();

    boolean isAvailable();

    boolean requiresSubscription();

    UUID getPricingId();



}
