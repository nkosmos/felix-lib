package fr.nkosmos.felix.api.common.entities.user.impl;

import fr.nkosmos.felix.api.common.entities.user.UserStatus;
import fr.nkosmos.felix.api.common.entities.user.UserType;

import java.util.UUID;

/**
 * Entity representation of a user, containing private information as well as setters
 *
 * @author xTrM_
 */
public class SelfUser extends PublicUser {

    public SelfUser(String username, String displayName, UserStatus status, String description, String profilePicture, UUID uuid, UserType userType) {
        super(username, displayName, status, description, profilePicture, uuid, userType);
    }
}
