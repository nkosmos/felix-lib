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

package fr.nkosmos.felix.api.common.entities.marketplace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for different resource flags as well as their accepted values
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum ResourceFlag {
	
	DEV_LANG("felix.api.marketplace.resource.flag.devlang"),
	SUPPORTED_LANGUAGES("felix.api.marketplace.resource.flag.supported_languages");
	
	/** The i18n description (used for translations) */
	private final String i18nDescription;

}
