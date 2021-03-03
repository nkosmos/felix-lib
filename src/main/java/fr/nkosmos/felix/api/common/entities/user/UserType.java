package fr.nkosmos.felix.api.common.entities.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for website user types
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum UserType {

    MEMBER("felix.api.user.type.member"),
    SUPPORTER("felix.api.user.type.supporter"),
    DEVELOPER("felix.api.user.type.developer"),
    SUPPORT("felix.api.user.type.support"),
    MOD("felix.api.user.type.moderator"),
    MANAGER("felix.api.type.rank.manager"),
    ADMIN("felix.api.type.rank.admin");
    
    /** The i18n name (for translation) */
    private final String i18nName;
    
}
