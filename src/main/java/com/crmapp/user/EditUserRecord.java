package com.crmapp.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EditUserRecord(
        Long id,
        @NotBlank String firstname,
        @NotBlank String lastname,
        @Email String email,
        UserRole role
) {
}
