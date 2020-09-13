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

package fr.nkosmos.felix.api.common.entities.user;

import java.util.UUID;

import fr.nkosmos.felix.api.common.entities.user.subscription.ISubscriptionData;

/**
 * Entity interface for a Rupture user, containing publicly available informations
 * 
 * @author xTrM_
 */
public interface IUser {
	
	/**
	 * @return the user's name
	 */
	String username();
	
	/**
	 * @return the user's display name
	 */
	String displayName();
	
	/**
	 * @return the user's uuid
	 */
	UUID uuid();
	
	/**
	 * @return the user's description
	 */
	String description();
	
	/**
	 * @return the user's avatar encoded in base64
	 */
	String b64image();
	
	/**
	 * @return the user's subscription type
	 */
	ISubscriptionData subscription();
	
	/**
	 * @return the user's website rank
	 */
	UserRank rank();
	
}
