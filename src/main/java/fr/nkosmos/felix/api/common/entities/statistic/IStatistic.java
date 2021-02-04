package fr.nkosmos.felix.api.common.entities.statistic;

import java.util.IntSummaryStatistics;

/**
 * Entity interface for a statistic value over a period of time
 * 
 * @author xTrM_
 */
public interface IStatistic {
    
    /**
     * @return the statistic's name
     */
    String name();

    /**
     * @return a summary of all the registered stats
     */
    IntSummaryStatistics summary();
    
    /**
     * Registers a stat value
     * 
     * @param unixTimestamp
     *         the value's timestamp
     * @param value
     *         the value
     * @return if this value has correctly been added
     */
    boolean add(long unixTimestamp, int value);
    
    /**
     * @return if this statistic has correctly been cleared
     */
    boolean clear();
    
    /**
     * @return this statistic's timespan (Default: {@link StatisticTimespan#FOREVER})
     */
    StatisticTimespan timespan();
    
    /**
     * Trims this statistic's value to a certain {@link StatisticTimespan Timespan}
     * @param timespan
     *         the desired timespan
     * @return this statistic's trimmed value
     */
    IStatistic forTimespan(StatisticTimespan timespan);

}
