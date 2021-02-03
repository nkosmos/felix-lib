package fr.nkosmos.felix.api.client.request;

import lombok.Data;

import static fr.nkosmos.felix.api.client.request.Method.*;

/**
 * Class defining how a request to an endpoint should be handled with which arguments.<br>
 * 
 * Heavily inspired by <a href="https://github.com/DV8FromTheWorld/JDA/blob/v3.8.3/src/main/java/net/dv8tion/jda/core/requests/Route.java">DV8FromTheWorld/JDA</a>
 * 
 * @author xTrM_
 */
public @Data class Route {

    public static class Defaults { 
        
        public static class Self {
            public static final Route GET_SELF = new Route(GET, "/users/self");
            public static final Route UPDATE_SELF = new Route(PUT, "/users/self");
        }
        
        public static class User {
            public static final Route GET_USER = new Route(GET, "/users/%s");
        }
        
        public static class Authentication {
            public static final Route LOGIN = new Route(POST, "/auth/login");
            public static final Route DISCONNECT = new Route(POST, "/auth/disconnect");
            public static final Route INTEGRITY = new Route(POST, "/auth/integrity");
        }
        
        public static class Application {
            public static final Route LIST_APPLICATIONS = new Route(GET, "/applications");
            public static final Route GET_APPLICATION_INFO = new Route(GET, "/applications/%s");
            public static final Route GET_STREAM = new Route(POST, "/applications/%s/download/%s");
            public static final Route GET_STATISTICS = new Route(POST, "/applications/%s/statistics");
        }
        
        public static class Marketplace {
            public static final Route LIST_RESOURCES = new Route(GET, "/marketplace/repositories/list");
            public static final Route GET_RESOURCE = new Route(GET, "/marketplace/repositories/%s");
            public static final Route GET_STREAM = new Route(GET, "/marketplace/repositories/%s/download/%s");
            public static final Route GET_STATISTICS = new Route(GET, "/marketplace/repositories/%s/statistics");
        }
        
        public static class Discord {
            public static final Route USER_INFO = new Route(GET, "/discord/users/%s");
        }
        
        public static class Statistics {
            
        }
    }
    
    /** The request method */
    private final Method method;
    /** The endpoint */
    private final String endpoint;
    /** The parameter count */
    private final int paramCount = getParamCount();
    
    public CompiledRoute compile(String... args) {
        if(args.length != paramCount) {
            throw new IllegalArgumentException("Route cannot be compiled with " + (args.length < paramCount ? "less" : "more") + " than " + paramCount + " arguments!");
        }
        
        String endpoint = String.format(this.endpoint, (Object[])args);
        return new CompiledRoute(this, endpoint);
    }
    
    private int getParamCount() {
        int paramCount = 0;
        int count2 = 0;
        
        for(int i = 0; i < (endpoint != null ? endpoint.length() : 0); i++) {
            if(endpoint.charAt(i) == '{') {
                paramCount++;
            }
            if(endpoint.charAt(i) == '}') {
                count2++;
            }
        }
        
        if(paramCount != count2) {
            throw new IllegalArgumentException("An argument does not have both {}'s for route: " + toString());
        }
        
        return paramCount;
    }
    
    /**
     * The compiled version of a {@link Route}, meaning it contains the required "argument-full" endpoint
     * 
     * @author xTrM_
     */
    public static @Data class CompiledRoute {
        private final Route baseRoute;
        private final String endpoint;
        
        public String getURL(String base) {
            return base + this.endpoint;
        }
    }
}