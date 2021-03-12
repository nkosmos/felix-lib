package fr.nkosmos.felix.api.common.entities.marketplace.resource;

import fr.nkosmos.felix.api.common.entities.marketplace.Category;
import fr.nkosmos.felix.api.common.entities.user.UserType;

import java.util.Map;
import java.util.UUID;

public interface IResource {

    String getName();

    UUID getUuid();

    UUID getAuthorUuid();

    String getDescription();

    Category getCategory();

    Map<ResourceFlag, String> getFlags();

    boolean canComment(UserType type);

}
