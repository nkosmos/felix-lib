package fr.nkosmos.felix.api.common.entities.subscription;

import lombok.Data;

/**
 * Entity representation for an Application subscription
 * 
 * @author xTrM_
 */
public @Data class SubscriptionData {

    private final SubscriptionType type;
    private final long purchaseDate;
    private final long expirationDate;

}
