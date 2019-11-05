package org.guis.notas.web.config;

import org.guis.notas.web.entities.UserCredentials;
import org.guis.notas.web.models.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserWithInfo extends User {
    private UserInfo info;

    public UserWithInfo(UserCredentials user, UserInfo info, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.info = info;
    }

    public UserWithInfo(UserCredentials user, UserInfo info, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), user.isActive(), accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.info = info;
    }

    public UserInfo getInfo() {
        return info;
    }
}
