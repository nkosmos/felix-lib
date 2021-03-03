package fr.nkosmos.felix.api.common.entities.user;

import java.util.UUID;

public interface IUser {

    String getUsername();

    String getDisplayName();

    UserStatus getStatus();

    String getDescription();

    String getProfilePicture();

    UUID getUuid();

    UserType getUserType();

}
