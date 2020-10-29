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

package fr.nkosmos.felix.api.common.entities.application;

import java.net.URL;
import java.util.UUID;

import fr.nkosmos.felix.api.client.request.Request;
import fr.nkosmos.felix.api.common.entities.statistic.IStatistic;

/**
 * Entity interface for any Rupture Application
 * 
 * @author xTrM_
 */
public interface IApplication {
	
	/**
	 * @return the name
	 */
	String name();
	
	/**
	 * @return the version
	 */
	String version();
	
	/**
	 * @return the authors' uuids
	 */
	UUID[] authors();
	
	/**
	 * @return the uuid
	 */
	UUID uuid();

	/**
	 * @return the bundle's URL
	 */
	URL bundleURL();
	
	/**
	 * @return a pre-built request to get the downloads statistic
	 */
	Request<IStatistic> downloads();
	
	/**
	 * @return wheather or not this application is available
	 */
	default boolean available() {
		return true;
	}

}
