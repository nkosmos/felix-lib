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

package fr.nkosmos.felix.api.common.cache;

import fr.nkosmos.felix.api.client.request.Request;

/**
 * Provides an easy way to cache and clear a request and its value
 * 
 * @author xTrM_
 */
public interface Cached<T> {
	
	/**
	 * @return the request to refresh the cached object
	 */
	Request<T> getRequest();

	/**
	 * @return get the cached object
	 */
	T get();
	
	/**
	 * Refresh the cached object
	 * @return if the object has been successfully refreshed
	 */
	boolean refresh();
	
	/**
	 * Clears the cached object
	 * @return if the object has been successfully cleared
	 */
	boolean clear();
	
}
