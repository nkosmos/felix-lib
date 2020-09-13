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

package fr.nkosmos.felix.api.server;

import fr.nkosmos.felix.api.server.sql.ISQLWrapper;

/**
 * Base interface for a Felix API server
 * 
 * @author xTrM_
 */
public interface IFelixServer {
	
	/**
	 * Internal loading sequence
	 */
	default void load0() {
		ServerProvider._defineServer(this);
		load();
	}
	
	/**
	 * Start the server
	 */
	void load();
	
	/**
	 * @return the SQL wrapper
	 */
	ISQLWrapper getSQLWrapper();

}