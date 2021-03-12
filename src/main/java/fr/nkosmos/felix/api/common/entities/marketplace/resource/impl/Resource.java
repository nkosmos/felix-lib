package fr.nkosmos.felix.api.common.entities.marketplace.resource.impl;

import fr.nkosmos.felix.api.common.entities.marketplace.Category;
import fr.nkosmos.felix.api.common.entities.marketplace.resource.IResource;
import fr.nkosmos.felix.api.common.entities.marketplace.resource.ResourceFlag;
import fr.nkosmos.felix.api.common.entities.user.UserType;
import lombok.Data;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * Entity representation of a publicly available marketplace resource
 * 
 * @author xTrM_
 */
public @Data class Resource implements IResource {

    private final String name;
    private final UUID uuid, authorUuid;
    private final String description;
    private final Category category;
    private final Map<ResourceFlag, String> flags;
    private final UserType[] commentAllowedTypes;

    @Override
    public boolean canComment(UserType type) {
        return Arrays.asList(commentAllowedTypes).contains(type);
    }
}
