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

package fr.nkosmos.felix.api.common.entities.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum containing the authentication actions
 * 
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum AuthenticationAction {

	LOGIN("felix.api.auth.action.login"),
	LOGOUT("felix.api.auth.action.logout"),
	REGISTER("felix.api.auth.action.register");
	
	/** The i18n name (used for translations) */
	private final String i18nName;
	
}
