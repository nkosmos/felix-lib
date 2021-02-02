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

package fr.nkosmos.felix.api.common.exceptions;

/**
 * Exception thrown when usage of an invalid api key
 * 
 * @author xTrM_
 */
public class DeniedException extends FelixException {

	public DeniedException(String message) {
		super(message);
	}

	public DeniedException(Throwable cause) {
		super(cause);
	}
	
	public DeniedException(String message, StackTraceElement[] callsite) {
		super(message, callsite);
	}
	
}
