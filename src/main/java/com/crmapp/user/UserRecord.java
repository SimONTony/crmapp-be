package com.crmapp.user;

import java.time.LocalDateTime;

public record UserRecord(
        Long id,
        String username,
        String enabled,
        String locked,
        LocalDateTime lastLoginAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
