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
 * Enum of marketplace categories
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum Category {

	THEME("felix.api.marketplace.category.theme"),
	MODULE("felix.api.marketplace.category.module"),
	COSMETIC("felix.api.marketplace.category.cosmetic"),
	MAPPING("felix.api.marketplace.category.mapping"),
	INTERFACE("felix.api.marketplace.category.interface"),
	TRANSLATION("felix.api.marketplace.category.translation"),
	OTHER("felix.api.marketplace.category.other");
	
	/** The i18n name (used for translations) */
	private final String i18nName;

}
