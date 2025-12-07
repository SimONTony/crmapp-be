package com.crmapp.user;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UserRecord(
        Long id,
        @NotBlank String firstname,
        @NotBlank String lastname,
        String email,
        @NotBlank String personalCode,
        @NotBlank UserRole role,
        @NotBlank UserStatus status,
        @NotBlank Boolean requirePasswordChange,
        String phone,
        Boolean mfaEnabled,
        LocalDateTime lastLogin,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}