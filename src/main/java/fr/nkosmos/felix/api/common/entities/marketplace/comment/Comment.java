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

package fr.nkosmos.felix.api.common.entities.marketplace.comment;

import fr.nkosmos.felix.api.common.IPersonalUpdater;
import fr.nkosmos.felix.api.common.entities.IPersonal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * Entity representation of a resource comment
 * 
 * @author xTrM_
 */
public @Data class Comment {

	private final String content;
	private final UUID uuid, authorUUID, resourceUUID;

	@Getter
	@EqualsAndHashCode(callSuper = true)
	@ToString
	public static class PersonalComment extends Comment implements IPersonal {
		private final IPersonalUpdater updater;

		public PersonalComment(IPersonalUpdater updater, String content, UUID uuid, UUID authorUUID, UUID resourceUUID){
			super(content, uuid, authorUUID, resourceUUID);
			this.updater = updater;
		}

		@Override
		public IPersonalUpdater updater() {
			return updater;
		}
	}
	
}
