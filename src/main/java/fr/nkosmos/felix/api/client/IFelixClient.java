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

package fr.nkosmos.felix.api.client;

import java.net.URL;

import com.google.gson.JsonElement;

import fr.nkosmos.felix.api.client.request.Request;
import fr.nkosmos.felix.api.client.request.Route.CompiledRoute;
import fr.nkosmos.felix.api.common.request.IRequestWrapper;

/**
 * Base interface for a Client implementation of Felix
 * 
 * @author xTrM_
 */
public interface IFelixClient extends IRequestWrapper {

	/**
	 * @return the base server URL
	 */
	URL getBaseURL();

	/**
	 * Prepares a request to a {@link CompiledRoute}
	 * @param <T>
	 * 		the type the request should return
	 * @param route
	 * 		the route used
	 * @return a new {@link Request}
	 */
	default <T> Request<T> request(CompiledRoute route) {
		return request(route, null);
	}
	
	/**
	 * Prepares a request to a {@link CompiledRoute} with a prepared {@link JsonElement}
	 * @param <T>
	 * 		the type the request should return
	 * @param route
	 * 		the route used
	 * @param body
	 * 		the request's json body
	 * @return a new {@link Request}
	 */
	<T> Request<T> request(CompiledRoute route, JsonElement body);

}
