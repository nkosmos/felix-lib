package fr.nkosmos.felix.api.common.entities.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum containing the authentication actions
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum AuthenticationAction {

    LOGIN("felix.api.auth.action.login"),
    LOGOUT("felix.api.auth.action.logout"),
    REGISTER("felix.api.auth.action.register");
    
    /** The i18n name (used for translations) */
    private final String i18nName;
    
}
