package fr.nkosmos.felix.api.common;

import fr.nkosmos.felix.api.common.entities.IPersonal;

public interface IPersonalUpdater {

    void update(IPersonal personalEntity, String fieldName, Object value);

}
