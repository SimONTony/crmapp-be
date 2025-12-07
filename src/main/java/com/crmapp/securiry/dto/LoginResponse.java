package com.crmapp.securiry.dto;

import ee.hansab.ella.user.model.CurrentUserRecord;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private CurrentUserRecord currentUser;

}
