package com.crmapp.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRecord(
        @NotBlank String firstname,
        @NotBlank String lastname,
        @Email String email,
        @NotBlank String password,
        UserRole role
) {
}
