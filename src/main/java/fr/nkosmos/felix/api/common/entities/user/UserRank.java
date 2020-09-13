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

package fr.nkosmos.felix.api.common.entities.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for website user ranks
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum UserRank {

	MEMBER("felix.api.user.rank.member"),
	PREMIUM("felix.api.user.rank.premium"),
	SUPPORTER("felix.api.user.rank.supporter"),
	SUPPORT("felix.api.user.rank.support"),
	MOD("felix.api.user.rank.moderator"),
	MANAGER("felix.api.user.rank.manager"),
	ADMIN("felix.api.user.rank.admin");
	
	/** The i18n name (for translation) */
	private final String i18nName;
	
}
