package com.crmapp.securiry.jwt;

import com.crmapp.user.UserEntity;
import com.crmapp.user.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserEntity user) {
        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getUpdatedAt(),
                mapToGrantedAuthorities(List.of(UserRole.SUPERADMIN))); // todo roles
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }
}
