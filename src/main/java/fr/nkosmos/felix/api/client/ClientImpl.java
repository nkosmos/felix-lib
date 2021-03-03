package fr.nkosmos.felix.api.client;

import com.github.natanbc.reliqua.Reliqua;
import com.github.natanbc.reliqua.limiter.factory.RateLimiterFactory;
import com.github.natanbc.reliqua.request.PendingRequest;
import com.github.natanbc.reliqua.util.StatusCodeValidator;
import fr.nkosmos.felix.api.client.request.Route;
import fr.nkosmos.felix.api.client.util.RequestUtils;
import fr.nkosmos.felix.api.common.entities.application.Application;
import fr.nkosmos.felix.api.common.entities.auth.AuthenticationResponse;
import fr.nkosmos.felix.api.common.entities.marketplace.Resource;
import fr.nkosmos.felix.api.common.entities.marketplace.comment.Comment;
import fr.nkosmos.felix.api.common.entities.user.impl.PublicUser;
import fr.nkosmos.felix.api.common.entities.user.impl.SelfUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
public @Data class ClientImpl extends Reliqua implements FelixClient {

    private static final Logger LOGGER = LogManager.getLogger("FelixClient");
    private static final String API_BASE = "https://nkosmos.fr/api/v2";
    
    private final String userAgent;
    private String authorizationToken;

    public ClientImpl(OkHttpClient client, RateLimiterFactory factory, boolean trackCallSites, String userAgent) {
        super(client, factory, trackCallSites);
        this.userAgent = userAgent;
    }

    @Override
    public PendingRequest<AuthenticationResponse> requestAuthentication(String identifier, String authentifier) {
        return null;
    }

    @Override
    public PendingRequest<PublicUser> requestUser(UUID userId) {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<SelfUser> requestSelfUser() {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Resource> requestResource(UUID uuid) {
        requiresAuthorization();
        return createRequest(
                    newRequestBuilder(Route.Defaults.Marketplace.GET_RESOURCE.compile(uuid.toString()).getURL(API_BASE))
                    .header("Authorization", authorizationToken)
                    .get()
                )
                .setRateLimiter(getRateLimiter("/marketplace"))
                .setStatusCodeValidator(StatusCodeValidator.ACCEPT_200)
                .build(response -> RequestUtils.toJson(response, Resource.class), RequestUtils::handleError);
    }

    @Override
    public PendingRequest<Set<Resource>> requestResources(UUID userId) {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Resource.PersonalResource> requestPersonalResource(UUID uuid) {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Set<Resource.PersonalResource>> requestPersonalResources() {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Comment> requestComment(UUID uuid) {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Set<Comment>> requestComments(UUID userId) {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Comment.PersonalComment> requestPersonalComment(UUID uuid) {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Set<Comment.PersonalComment>> requestPersonalComments() {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Set<Application>> requestApplications() {
        requiresAuthorization();
        return null;
    }

    @Override
    public PendingRequest<Application> requestApplication(UUID uuid) {
        requiresAuthorization();
        return null;
    }
    
    private void requiresAuthorization() {
        if(authorizationToken == null || authorizationToken.isEmpty())
            throw new IllegalStateException("This endpoint requires an authorization token.");
    }
    
    @CheckReturnValue
    @Nonnull
    public Request.Builder newRequestBuilder(@Nonnull String url) {
        return new Request.Builder()
            .header("User-Agent", userAgent)
            .header("Accept-Encoding", "gzip, deflate")
            .url(url);
    }
}
