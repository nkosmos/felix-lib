package fr.nkosmos.felix.api.common.exceptions;

/**
 * Exception thrown when usage of an invalid authentication token 
 * 
 * @author xTrM_
 */
public class InvalidAuthenticationException extends FelixException {

    public InvalidAuthenticationException(String message) {
        super(message);
    }

    public InvalidAuthenticationException(Throwable cause) {
        super(cause);
    }
    
    public InvalidAuthenticationException(String message, StackTraceElement[] callsite) {
        super(message, callsite);
    }
}
