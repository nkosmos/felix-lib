package fr.nkosmos.felix.api.client;

import com.github.natanbc.reliqua.limiter.factory.RateLimiterFactory;
import fr.nkosmos.felix.api.client.wrapper.IClientWrapper;
import okhttp3.OkHttpClient;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Base interface for a Client implementation of Felix
 * 
 * @author xTrM_
 */
public interface FelixClient extends IClientWrapper {

    class Builder {
        private String url;
        private OkHttpClient client;
        private RateLimiterFactory rateLimiterFactory;
        private boolean trackCallSites;

        @CheckReturnValue
        @Nonnull
        public FelixClient build() {
            return new ClientImpl(
                    url,
                    client == null ? new OkHttpClient() : client,
                    rateLimiterFactory,
                    trackCallSites,
                    String.format("felix-client v%s", "indev") //TODO change this
            );
        }

        @CheckReturnValue
        @Nonnull
        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        @CheckReturnValue
        @Nonnull
        public Builder setCallSiteTrackingEnabled(boolean enabled) {
            this.trackCallSites = enabled;
            return this;
        }

        @CheckReturnValue
        @Nonnull
        public Builder setHttpClient(@Nullable OkHttpClient client) {
            this.client = client;
            return this;
        }

        @CheckReturnValue
        @Nonnull
        public Builder setRateLimiterFactory(@Nullable RateLimiterFactory factory) {
            this.rateLimiterFactory = factory;
            return this;
        }
    }

}
