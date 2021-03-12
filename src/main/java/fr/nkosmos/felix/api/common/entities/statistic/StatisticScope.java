package fr.nkosmos.felix.api.common.entities.statistic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of statistic scopes
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum StatisticScope {
    
    APPLICATION("felix.api.statistic.scope.application"),
    DISCORD("felix.api.statistic.scope.discord"),
    RESOURCE("felix.api.statistic.scope.resource"),
    USER("felix.api.statistic.scope.user");
    
    /** The i18n description (used for translations) */
    private final String i18nDescription;

}
