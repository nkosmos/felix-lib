package fr.nkosmos.felix.api.common.entities.marketplace.comment;

import fr.nkosmos.felix.api.common.IPersonalUpdater;
import fr.nkosmos.felix.api.common.entities.IPersonal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * Entity representation of a resource comment
 * 
 * @author xTrM_
 */
public @Data class Comment {

    private final String content;
    private final UUID uuid, authorUUID, resourceUUID;

    @Getter
    @EqualsAndHashCode(callSuper = true)
    @ToString
    public static class PersonalComment extends Comment implements IPersonal {
        private final IPersonalUpdater updater;

        public PersonalComment(IPersonalUpdater updater, String content, UUID uuid, UUID authorUUID, UUID resourceUUID){
            super(content, uuid, authorUUID, resourceUUID);
            this.updater = updater;
        }

        @Override
        public IPersonalUpdater updater() {
            return updater;
        }
    }
    
}
