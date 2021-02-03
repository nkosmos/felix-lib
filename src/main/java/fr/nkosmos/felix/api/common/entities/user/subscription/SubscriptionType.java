/**
 * This file is a part of the felix-api GitHub project.
 *
 * felix-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * felix-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with felix-api. If not, see <https://www.gnu.org/licenses/>.
 */

package fr.nkosmos.felix.api.common.entities.user.subscription;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for subscription types
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum SubscriptionType {

    NONE("felix.api.user.subscription.type.none"),
    SUBSCRIBED("felix.api.user.subscription.type.subscribed");
    
    /** The i18n type (used for translations) */
    private final String i18nDescription;
    
}
