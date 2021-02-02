package fr.nkosmos.felix.api.common.entities.marketplace;

import fr.nkosmos.felix.api.common.IPersonalUpdater;
import fr.nkosmos.felix.api.common.entities.IPersonal;
import fr.nkosmos.felix.api.common.entities.user.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

/**
 * Entity representation of a publicly available marketplace resource
 * 
 * @author xTrM_
 */
public @Data class Resource {

	private final String name;
	private final UUID uuid;
	private final Category category;
	private final Map<ResourceFlag, String> flags;
	private final UserType[] canComment;

	@Getter
	@EqualsAndHashCode(callSuper = true)
	@ToString
	public static class PersonalResource extends Resource implements IPersonal {

		public PersonalResource(String name, UUID uuid, Category category, Map<ResourceFlag, String> flags, UserType[] canComment) {
			super(name, uuid, category, flags, canComment);
		}

		@Override
		public IPersonalUpdater updater() {
			return null;
		}
	}
}
