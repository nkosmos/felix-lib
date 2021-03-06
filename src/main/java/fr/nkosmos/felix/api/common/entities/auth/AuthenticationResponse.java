package fr.nkosmos.felix.api.common.entities.auth;

import lombok.Data;

/**
 * Entity interface for an Authentication API response
 * 
 * @author xTrM_
 */
public @Data class AuthenticationResponse {

    private final String responseMessage;
    private final String responseData;
    
}
