package fr.nkosmos.felix.api.common.exceptions;

/**
 * Exception thrown when usage of an invalid api key
 * 
 * @author xTrM_
 */
public class DeniedException extends FelixException {

    public DeniedException(String message) {
        super(message);
    }

    public DeniedException(Throwable cause) {
        super(cause);
    }
    
    public DeniedException(String message, StackTraceElement[] callsite) {
        super(message, callsite);
    }
    
}
