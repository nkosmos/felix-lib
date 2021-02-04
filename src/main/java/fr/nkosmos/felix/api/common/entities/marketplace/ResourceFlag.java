package fr.nkosmos.felix.api.common.entities.marketplace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for different resource flags as well as their accepted values
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum ResourceFlag {
    
    DEV_LANG("felix.api.marketplace.resource.flag.devlang"),
    SUPPORTED_LANGUAGES("felix.api.marketplace.resource.flag.supported_languages");
    
    /** The i18n description (used for translations) */
    private final String i18nDescription;

}
