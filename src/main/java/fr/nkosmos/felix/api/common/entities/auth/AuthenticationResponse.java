package fr.nkosmos.felix.api.common.entities.auth;

import lombok.Data;

/**
 * Entity interface for an Authentication API response
 * 
 * @author xTrM_
 */
public @Data class AuthenticationResponse {

    private final AuthenticationResponseCode responseCode;
    private final String responseData;
    
}
