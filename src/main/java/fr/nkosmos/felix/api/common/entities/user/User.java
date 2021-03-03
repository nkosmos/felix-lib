package fr.nkosmos.felix.api.common.entities.user;

import lombok.Data;

import java.util.UUID;

/**
 * Entity representation of a user, containing publicly available informations
 * 
 * @author xTrM_
 */
public @Data class User implements IUser {
    
    private final String username;
    private final UUID uuid;
    protected final String displayName, description, profilePicture;
    private final UserStatus status;
    private final UserType userType;

}
