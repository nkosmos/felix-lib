package fr.nkosmos.felix.api.common.entities.user.subscription;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for subscription types
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum SubscriptionType {

    NONE("felix.api.user.subscription.type.none"),
    SUBSCRIBED("felix.api.user.subscription.type.subscribed");
    
    /** The i18n type (used for translations) */
    private final String i18nDescription;
    
}
