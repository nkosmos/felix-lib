package fr.nkosmos.felix.api.common.exceptions;

import com.github.natanbc.reliqua.request.RequestException;

/**
 * Superclass of any Felix Exception
 * 
 * @author xTrM_
 */
public class FelixException extends RequestException {

    public FelixException(String message) {
        super(message);
    }

    public FelixException(Throwable cause) {
        super(cause);
    }
    
    public FelixException(String message, StackTraceElement[] callsite) {
        super(message, callsite);
    }

}
