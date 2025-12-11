package com.crmapp.user;

public record CurrentUserRecord(
        Long id,
        String username,
        boolean enabled
) {
}
