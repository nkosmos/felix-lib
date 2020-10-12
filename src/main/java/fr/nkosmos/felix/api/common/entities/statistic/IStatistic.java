/**
 * This file is a part of the felix-api GitHub project.
 *
 * felix-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * felix-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with felix-api. If not, see <https://www.gnu.org/licenses/>.
 */

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
	 * 		the value's timestamp
	 * @param value
	 * 		the value
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
	 * 		the desired timespan
	 * @return this statistic's trimmed value
	 */
	IStatistic forTimespan(StatisticTimespan timespan);

}
