package fr.nkosmos.felix.api.common.entities.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for user statuses
 *
 * @author xTrM_
 */
@Getter
@RequiredArgsConstructor
public enum UserStatus {

    OFFLINE("felix.api.user.status.offline"),
    ONLINE("felix.api.user.status.online"),
    DO_NOT_DISTURB("felix.api.user.status.do_not_disturb"),
    AWAY("felix.api.user.status.away"),
    INVISIBLE("felix.api.user.status.invisible");

    /** The i18n name (for translation) */
    private final String i18nName;

}
