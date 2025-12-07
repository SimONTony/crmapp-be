package com.crmapp.user;

public record CurrentUserRecord(
        Long id,
        String name,
        boolean enabled,
        UserRole role,
        UserStatus status,
        String email
) {
}
