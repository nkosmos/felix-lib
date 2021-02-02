package fr.nkosmos.felix.api.common.entities.error;

import lombok.Data;

/**
 * Entity representation of any API Error
 * 
 * @author xTrM_
 */
public @Data class Error {
	
	private final String errorName, errorMessage, errorClass;

}
