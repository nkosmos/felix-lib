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

package fr.nkosmos.felix.api.common.entities.error;

/**
 * Entity interface for any API Error
 * 
 * @author xTrM_
 */
public interface IError {
	
	/**
	 * @return the error's class
	 */
	default String errorClass() {
		return "fr.nkosmos.felix.api.common.exceptions.FelixException";
	}
	
	/**
	 * @return the error's name
	 */
	String errorName();
	
	/**
	 * @return the error message
	 */
	String errorMessage();

}
