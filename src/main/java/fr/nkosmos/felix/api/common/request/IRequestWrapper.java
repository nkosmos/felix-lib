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

package fr.nkosmos.felix.api.common.request;

import java.util.Set;
import java.util.UUID;

import fr.nkosmos.felix.api.client.request.Request;
import fr.nkosmos.felix.api.common.entities.marketplace.IResource;
import fr.nkosmos.felix.api.common.entities.marketplace.comment.IComment;
import fr.nkosmos.felix.api.common.entities.marketplace.comment.personal.IPersonalComment;
import fr.nkosmos.felix.api.common.entities.marketplace.personal.IPersonalResource;
import fr.nkosmos.felix.api.common.entities.stream.IApplication;
import fr.nkosmos.felix.api.common.entities.user.IUser;
import fr.nkosmos.felix.api.common.entities.user.personal.IPersonalUser;
import fr.nkosmos.felix.api.common.exceptions.InvalidAuthenticationException;

/**
 * Interface for a wrapper around the different entities and their requests
 * 
 * @author xTrM_
 */
public interface IRequestWrapper {
	
	/**
	 * Builds a request to get a User from a {@link UUID}
	 * @param uuid
	 * 		the user's uuid
	 * @return a {@link Request} for the {@link IUser} with that uuid
	 */
	Request<IUser> requestUser(UUID uuid);

	/**
	 * Builds a request to get a PersonalUser from a private token
	 * @param token
	 * 		the user's token
	 * @return a {@link Request} for the {@link IPersonalUser} with that token
	 */
	Request<IPersonalUser> requestUser(String token) throws InvalidAuthenticationException;
	
	/**
	 * Builds a request to get a Resource from a {@link UUID}
	 * @param uuid
	 * 		the resource's uuid
	 * @return a {@link Request} for the {@link IResource} with that uuid
	 */
	Request<IResource> requestResource(UUID uuid);
	
	/**
	 * Builds a request to get a PersonalResource from a private token
	 * @param token
	 * 		the user's token
	 * @param uuid
	 * 		the resource's uuid
	 * @return a {@link Request} for the {@link IPersonalResource} with that token
	 */
	Request<IPersonalResource> requestResource(String token, UUID uuid) throws InvalidAuthenticationException;
	
	/**
	 * Builds a request to get all PersonalResources from a private token
	 * @param token
	 * 		the user's token
	 * @return a {@link Request} for a {@link Set} containing the {@link IPersonalResource} with that token
	 */
	Request<Set<IPersonalResource>> requestResources(String token) throws InvalidAuthenticationException;

	/**
	 * Builds a request to get a Comment from its UUID
	 * @param uuid
	 * 		the comment's uuid
	 * @return a {@link Request} for the {@link IComment} with that uuid
	 */
	Request<IComment> requestComment(UUID uuid);

	Request<Set<IComment>> requestComments(IUser user);
	
	Request<Set<IPersonalComment>> requestComment(String token, UUID uuid) throws InvalidAuthenticationException;
	
	Request<Set<IPersonalComment>> requestComments(String token) throws InvalidAuthenticationException;
	
	/**
	 * Builds a request to get an Application from a {@link UUID}
	 * @param uuid
	 * 		the application's uuid
	 * @return a {@link Request} for the {@link IApplication} with that uuid
	 */
	Request<IApplication> requestApplication(UUID uuid);

}
