package pl.wip.wipplatformbe.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, MODERATOR, WIPMEMBER, USER;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
