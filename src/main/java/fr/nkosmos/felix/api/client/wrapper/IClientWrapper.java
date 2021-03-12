package fr.nkosmos.felix.api.client.wrapper;

import com.github.natanbc.reliqua.request.PendingRequest;
import fr.nkosmos.felix.api.common.entities.application.impl.Application;
import fr.nkosmos.felix.api.common.entities.auth.AuthenticationResponse;
import fr.nkosmos.felix.api.common.entities.discord.DiscordUser;
import fr.nkosmos.felix.api.common.entities.marketplace.resource.impl.PersonalResource;
import fr.nkosmos.felix.api.common.entities.marketplace.resource.impl.Resource;
import fr.nkosmos.felix.api.common.entities.marketplace.comment.Comment;
import fr.nkosmos.felix.api.common.entities.user.impl.User;
import fr.nkosmos.felix.api.common.entities.user.impl.SelfUser;

import java.util.Set;
import java.util.UUID;

/**
 * Interface for a wrapper around the different entities and their requests
 * 
 * @author xTrM_
 */
public interface IClientWrapper {

    /**
     * Builds a request
     * @param identifier
     *         the user's identifier (name or email)
     * @param authentifier
     *         the user's authentifier (password)
     * @return a {@link PendingRequest} for the {@link AuthenticationResponse}
     */
    PendingRequest<AuthenticationResponse> requestAuthentication(String identifier, String authentifier);

    /**
     * Builds a request
     * @param name
     *         the user's name
     * @param email
     *         the user's email
     * @param authentifier
     *         the user's authentifier (password)
     * @return a {@link PendingRequest} for the {@link AuthenticationResponse}
     */
    PendingRequest<AuthenticationResponse> requestRegistration(String name, String email, String authentifier);
    
    /**
     * Builds a request to get a User from a {@link UUID}
     * @param userId
     *         the user's uuid
     * @return a {@link PendingRequest} for the {@link User} with that uuid
     */
    PendingRequest<User> requestUser(UUID userId);

    /**
     * Builds a request to get a PersonalUser
     * @return a {@link PendingRequest} for the {@link SelfUser}
     */
    PendingRequest<SelfUser> requestSelfUser();

    /**
     * Builds a request to get all available Resources
     * @return a {@link PendingRequest} for a {@link Set} containing all the available {@link Resource}s
     */
    PendingRequest<Set<Resource>> requestResources();

    /**
     * Builds a request to get a Resource from a {@link UUID}
     * @param uuid
     *         the resource's uuid
     * @return a {@link PendingRequest} for the {@link Resource} with that uuid
     */
    PendingRequest<Resource> requestResource(UUID uuid);
    
    /**
     * Builds a request to get a Resource from a User
     * @param userId
     *         the user's uuid
     * @return a {@link PendingRequest} for a {@link Set} containing all the user's {@link Resource}s
     */
    PendingRequest<Set<Resource>> requestResources(UUID userId);

    /**
     * Builds a request to get all PersonalResources
     * @return a {@link PendingRequest} for a {@link Set} containing all the user's {@link PersonalResource}s
     */
    PendingRequest<Set<PersonalResource>> requestPersonalResources();

    /**
     * Builds a request to get a PersonalResource from a private token
     * @param uuid
     *         the resource's uuid
     * @return a {@link PendingRequest} for the {@link PersonalResource} with that uuid
     */
    PendingRequest<PersonalResource> requestPersonalResource(UUID uuid);

    /**
     * Builds a request to get all Applications
     * @return a {@link PendingRequest} for a {@link Set} containing all the available {@link Application}s
     */
    PendingRequest<Set<Application>> requestApplications();

    /**
     * Builds a request to get an Application from a {@link UUID}
     * @param uuid
     *         the application's uuid
     * @return a {@link PendingRequest} for the {@link Application} with that uuid
     */
    PendingRequest<Application> requestApplication(UUID uuid);

    /**
     * Builds a request to get a Comment from its UUID
     * @param uuid
     *         the comment's uuid
     * @return a {@link PendingRequest} for the {@link Comment} with that uuid
     */
    PendingRequest<Comment> requestComment(UUID uuid);

    /**
     * Builds a request to get all Comments from a User
     * @param userId
     *         the user's uuid
     * @return a {@link PendingRequest} for a {@link Set} containing all the user's {@link Comment}s
     */
    PendingRequest<Set<Comment>> requestComments(UUID userId);
    
    /**
     * Builds a request to get a PersonalComment from its UUID
     * @param uuid
     *         the comment's uuid
     * @return a {@link PendingRequest} for the {@link Comment.PersonalComment} with that uuid
     */
    PendingRequest<Comment.PersonalComment> requestPersonalComment(UUID uuid);
    
    /**
     * Builds a request to get all PersonalComment
     * @return a {@link PendingRequest} for a {@link Set} containing all the user's {@link Comment.PersonalComment PersonalComments}
     */
    PendingRequest<Set<Comment.PersonalComment>> requestPersonalComments();

    /**
     * Builds a request to link your Discord account from a oauth2 code
     * @param oauth2Code
     *         the oauth2 code
     * @return a {@link DiscordUser} instance
     */
    PendingRequest<DiscordUser> linkAccount(String oauth2Code);

}
