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
import fr.nkosmos.felix.api.common.entities.application.IApplication;
import fr.nkosmos.felix.api.common.entities.marketplace.IResource;
import fr.nkosmos.felix.api.common.entities.marketplace.comment.IComment;
import fr.nkosmos.felix.api.common.entities.personal.impl.IPersonalComment;
import fr.nkosmos.felix.api.common.entities.personal.impl.IPersonalResource;
import fr.nkosmos.felix.api.common.entities.personal.self.ISelfUser;
import fr.nkosmos.felix.api.common.entities.user.IUser;

/**
 * Interface for a wrapper around the different entities and their requests
 * 
 * @author xTrM_
 */
public interface IRequestWrapper {
	
	/**
	 * Builds a request
	 * @param identifier
	 * 		the user's identifier (name or email)
	 * @param authentifier
	 * 		the user's authentifier (password)
	 * @return a {@link Request} for the Authentication Token
	 */
	Request<String> requestAuthentication(String identifier, String authentifier);
	
	/**
	 * Builds a request to get a User from a {@link UUID}
	 * @param apiKey
	 * 		the api access key
	 * @param userId
	 * 		the user's uuid
	 * @return a {@link Request} for the {@link IUser} with that uuid
	 */
	Request<IUser> requestUser(String apiKey, UUID userId);

	/**
	 * Builds a request to get a PersonalUser from a private token
	 * @param token
	 * 		the user's token
	 * @return a {@link Request} for the {@link ISelfUser} with that token
	 */
	Request<ISelfUser> requestSelfUser(String token);
	
	/**
	 * Builds a request to get a Resource from a {@link UUID}
	 * @param apiKey
	 * 		the api access key
	 * @param uuid
	 * 		the resource's uuid
	 * @return a {@link Request} for the {@link IResource} with that uuid
	 */
	Request<IResource> requestResource(String apiKey, UUID uuid);
	
	/**
	 * Builds a request to get a Resource from a User
	 * @param apiKey
	 * 		the api access key
	 * @param userId
	 * 		the user's uuid
	 * @return a {@link Request} for a {@link Set} containing all the user's {@link IResource Resources}
	 */
	Request<Set<IResource>> requestResources(String apiKey, UUID userId);
	
	/**
	 * Builds a request to get a PersonalResource from a private token
	 * @param token
	 * 		the user's token
	 * @param uuid
	 * 		the resource's uuid
	 * @return a {@link Request} for the {@link IPersonalResource} with that token
	 */
	Request<IPersonalResource> requestPersonalResource(String token, UUID uuid);
	
	/**
	 * Builds a request to get all PersonalResources from a private token
	 * @param token
	 * 		the user's token
	 * @return a {@link Request} for a {@link Set} containing all the user's {@link IPersonalResource PersonalResources}
	 */
	Request<Set<IPersonalResource>> requestPersonalResources(String token);

	/**
	 * Builds a request to get a Comment from its UUID
	 * @param apiKey
	 * 		the api access key
	 * @param uuid
	 * 		the comment's uuid
	 * @return a {@link Request} for the {@link IComment} with that uuid
	 */
	Request<IComment> requestComment(String apiKey, UUID uuid);

	/**
	 * Builds a request to get all Comments from a User
	 * @param apiKey
	 * 		the api access key
	 * @param userId
	 * 		the user's uuid
	 * @return a {@link Request} for a {@link Set} containing all the user's {@link IComment Comments}
	 */
	Request<Set<IComment>> requestComments(String apiKey, UUID userId);
	
	/**
	 * Builds a request to get a PersonalComment from its UUID
	 * @param token
	 * 		the user's token
	 * @param uuid
	 * 		the comment's uuid
	 * @return a {@link Request} for the {@link IPersonalComment} with that uuid
	 */
	Request<IPersonalComment> requestPersonalComment(String token, UUID uuid);
	
	/**
	 * Builds a request to get all PersonalComment from a private token
	 * @param token
	 * 		the user's token
	 * @return a {@link Request} for a {@link Set} containing all the user's {@link IPersonalComment PersonalComments}
	 */
	Request<Set<IPersonalComment>> requestPersonalComments(String token);
	
	/**
	 * Builds a request to get all Applications
	 * @param apiKey
	 * 		the api access key
	 * @return a {@link Request} for a {@link Set} containing all the {@link IApplication Applications}
	 */
	Request<Set<IApplication>> requestApplications(String apiKey);
	
	/**
	 * Builds a request to get an Application from a {@link UUID}
	 * @param apiKey
	 * 		the api access key
	 * @param uuid
	 * 		the application's uuid
	 * @return a {@link Request} for the {@link IApplication} with that uuid
	 */
	Request<IApplication> requestApplication(String apiKey, UUID uuid);

}
