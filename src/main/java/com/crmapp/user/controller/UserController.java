package com.crmapp.user.controller;

import com.crmapp.core.response.dto.BaseResponseDto;
import com.crmapp.securiry.dto.LoginRequest;
import com.crmapp.securiry.dto.LoginResponse;
import com.crmapp.securiry.jwt.JwtAuthenticationException;
import com.crmapp.securiry.jwt.JwtUser;
import com.crmapp.user.CreateUserRecord;
import com.crmapp.user.EditUserRecord;
import com.crmapp.user.UserRecord;
import com.crmapp.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("login")
    public BaseResponseDto<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        } catch (AuthenticationException exception) {
            throw new JwtAuthenticationException(exception.getMessage());
        }
        LoginResponse loginResponse = userService.authenticateUser(authentication);
        return new BaseResponseDto<>(loginResponse);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserRecord>> getAllUsers() {
        List<UserRecord> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "current")
    public ResponseEntity<UserRecord> getCurrentUser(@AuthenticationPrincipal JwtUser userPrincipal) {
        Long userId = userPrincipal.getId();
        UserRecord currentUser = userService.getCurrentUser(userId);
        return ResponseEntity.ok(currentUser);
    }

    @PostMapping("create")
    public ResponseEntity<UserRecord> createUser(@RequestBody CreateUserRecord userRecord) {
        UserRecord createdUser = userService.createUser(userRecord);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("edit")
    public ResponseEntity<UserRecord> editUser(@RequestBody EditUserRecord userRecord) {
        UserRecord updatedUser = userService.editUser(userRecord);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteUser(@RequestBody Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
