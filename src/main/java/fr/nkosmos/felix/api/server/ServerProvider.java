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

/**
 * Provider for a Felix {@link IFelixServer Server instance}
 * 
 * @author xTrM_
 */
public class ServerProvider {
	
	/** A {@link IFelixServer} instance */
	private static IFelixServer server;
	
	/**
	 * Define internally the server instance
	 * @param server
	 * 		the server instance
	 */
	static void _defineServer(IFelixServer server) {
		ServerProvider.server = server;
	}
	
	/**
	 * @return a {@link IFelixServer} instance
	 */
	public static IFelixServer getServer() {
		return server;
	}

}
