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
 * Superclass of any Felix Exception
 * 
 * @author xTrM_
 */
@SuppressWarnings("serial")
public class FelixException extends RuntimeException {
	
	public FelixException() {
		super();
	}

	public FelixException(String message) {
		super(message);
	}

	public FelixException(String message, Throwable cause) {
		super(message, cause);
	}

	public FelixException(Throwable cause) {
		super(cause);
	}

}
