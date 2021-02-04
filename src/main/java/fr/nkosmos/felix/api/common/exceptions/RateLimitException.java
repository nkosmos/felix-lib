package fr.nkosmos.felix.api.common.exceptions;

/**
 * Exception thrown when the server cancels the request because of rate limit
 * 
 * @author xTrM_
 */
public class RateLimitException extends FelixException {

    public RateLimitException(String message) {
        super(message);
    }

    public RateLimitException(Throwable cause) {
        super(cause);
    }
    
    public RateLimitException(String message, StackTraceElement[] callsite) {
        super(message, callsite);
    }

}
