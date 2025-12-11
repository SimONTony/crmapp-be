package com.crmapp.user.service;

import com.crmapp.securiry.dto.LoginResponse;
import org.springframework.security.core.Authentication;

public interface UserService {
    LoginResponse authenticateUser(Authentication authentication);
}
