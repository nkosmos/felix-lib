package fr.nkosmos.felix.api.common.entities.statistic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of statistic timespans
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum StatisticTimespan {

    MINUTE("felix.api.statistic.timespan.minute"),
    HOURLY("felix.api.statistic.timespan.hourly"),
    DAILY("felix.api.statistic.timespan.daily"),
    WEEKLY("felix.api.statistic.timespan.weekly"),
    MONTHLY("felix.api.statistic.timespan.monthly"),
    YEARLY("felix.api.statistic.timespan.yearly"),
    FOREVER("felix.api.statistic.timespan.forever");
    
    /** The i18n name (used for translations) */
    private final String i18nName;
    
}
