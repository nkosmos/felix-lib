package fr.nkosmos.felix.api.common.entities.marketplace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of marketplace categories
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum Category {

    THEME("felix.api.marketplace.category.theme"),
    MODULE("felix.api.marketplace.category.module"),
    COSMETIC("felix.api.marketplace.category.cosmetic"),
    MAPPING("felix.api.marketplace.category.mapping"),
    INTERFACE("felix.api.marketplace.category.interface"),
    TRANSLATION("felix.api.marketplace.category.translation"),
    OTHER("felix.api.marketplace.category.other");
    
    /** The i18n name (used for translations) */
    private final String i18nName;

}
