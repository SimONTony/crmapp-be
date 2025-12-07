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
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus().equals(UserStatus.ACTIVE),
                user.getUpdatedAt(),
                mapToGrantedAuthorities(List.of(user.getRole())));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }
}
