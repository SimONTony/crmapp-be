package com.crmapp.securiry.dto;

import com.crmapp.user.CurrentUserRecord;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private CurrentUserRecord currentUser;

}
