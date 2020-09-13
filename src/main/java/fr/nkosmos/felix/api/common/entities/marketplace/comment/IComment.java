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

package fr.nkosmos.felix.api.common.entities.marketplace.comment;

import java.util.List;
import java.util.UUID;

import fr.nkosmos.felix.api.client.request.Request;

/**
 * Entity interface for a resource comment
 * 
 * @author xTrM_
 */
public interface IComment {

	/**
	 * @return the comment's content
	 */
	String content();
	
	/**
	 * @return the comment's uuid
	 */
	UUID uuid();
	
	/**
	 * @return the comment's author's uuid
	 */
	UUID authorUUID();
	
	/**
	 * @return a request for the list of children comments
	 */
	Request<List<IComment>> childs();
	
	/**
	 * @return the linked resource uuid
	 */
	UUID resourceUUID();
	
}
