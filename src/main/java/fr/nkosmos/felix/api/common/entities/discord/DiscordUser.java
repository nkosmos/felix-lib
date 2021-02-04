package fr.nkosmos.felix.api.common.entities.discord;

import java.util.UUID;

import lombok.Data;

/**
 * Entity representation of a linked discord user
 * 
 * @author xTrM_
 */
public @Data class DiscordUser {
    
    private final long discordId;
    private final String name, discrim;
    private final UUID linkedUserUUID;

}
