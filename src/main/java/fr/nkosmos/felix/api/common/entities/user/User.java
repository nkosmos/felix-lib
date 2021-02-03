package fr.nkosmos.felix.api.common.entities.user;

import fr.nkosmos.felix.api.common.IPersonalUpdater;
import fr.nkosmos.felix.api.common.entities.IPersonal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * Entity representation of a user, containing publicly available informations
 * 
 * @author xTrM_
 */
public @Data class User {
    
    private final String username;
    private final UUID uuid;
    protected final String profileName, profilePicture, profileStatus;
    private final UserType userType;

    @Getter
    @EqualsAndHashCode(callSuper = true)
    @ToString
    public static class SelfUser extends User implements IPersonal {
        private final IPersonalUpdater updater;
        private final String email;

        public SelfUser(IPersonalUpdater updater, String username, UUID uuid, String profileName, String profilePicture, String profileStatus, UserType userType, String email){
            super(username, uuid, profileName, profilePicture, profileStatus, userType);
            this.updater = updater;
            this.email = email;
        }

        public void setProfileName(String profileName){
            updater.update(this, "profileName", profileName);
        }

        @Override
        public IPersonalUpdater updater() {
            return updater;
        }
    }
}
