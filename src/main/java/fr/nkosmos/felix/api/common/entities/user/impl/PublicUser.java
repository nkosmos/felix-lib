package fr.nkosmos.felix.api.common.entities.user.impl;

import fr.nkosmos.felix.api.common.entities.user.IUser;
import fr.nkosmos.felix.api.common.entities.user.UserStatus;
import fr.nkosmos.felix.api.common.entities.user.UserType;
import lombok.Data;

import java.util.UUID;

/**
 * Entity representation of a user, containing publicly available informations
 *
 * @author xTrM_
 */
public @Data class PublicUser implements IUser {

    private final String username, displayName;
    private final UserStatus status;
    private final String description, profilePicture;
    private final UUID uuid;
    private final UserType userType;

}
