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

package fr.nkosmos.felix.api.common.entities.marketplace;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import fr.nkosmos.felix.api.client.request.Request;
import fr.nkosmos.felix.api.common.entities.marketplace.comment.IComment;
import fr.nkosmos.felix.api.common.entities.statistic.IStatistic;
import fr.nkosmos.felix.api.common.entities.user.UserRank;
import fr.nkosmos.felix.api.common.entities.user.personal.IPersonalUser;

/**
 * Entity interface for a publicly available marketplace resource
 * 
 * @author xTrM_
 */
public interface IResource {

	/**
	 * @return the resource's name
	 */
	String name();
	
	/**
	 * @return the resource's uuid
	 */
	UUID uuid();
	
	/**
	 * @return the resource's category
	 */
	MarketplaceCategory category();

	/**
	 * @return the resource's flags
	 */
	Map<ResourceFlag, String> flags();
	
	/**
	 * @return the statistic for the number of stars
	 */
	Request<IStatistic> starCount();
	
	/**
	 * @return the statistic for the number of downloads
	 */
	Request<IStatistic> downloads();
	
	/**
	 * @return a pre-built request for getting the comments of this resource
	 */
	Request<List<IComment>> comments();
	
	/**
	 * @param rank
	 * 		the user rank
	 * @return a pre-built request for getting if this resource is accepting comments for this rank
	 */
	Request<Boolean> acceptsComments(UserRank rank);
	
	/**
	 * Builds a request to post a comment to this resource
	 * @param personalUser
	 * 		the personal user instance
	 * @param comment
	 * 		the comment to be posted
	 * @return a pre-built request returning a Boolean for wheather or not the request succeeded
	 */
	Request<Boolean> postComment(IPersonalUser personalUser, IComment comment);
	
	
}
