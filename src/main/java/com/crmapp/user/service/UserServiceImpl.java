package com.crmapp.user.service;

import com.crmapp.securiry.dto.LoginResponse;
import com.crmapp.securiry.jwt.JwtTokenProvider;
import com.crmapp.securiry.jwt.JwtUser;
import com.crmapp.user.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link UserService} interface providing user management operations.
 * This class handles user creation, retrieval, authentication, and deletion.
 * It uses a repository to persist user entities, encodes passwords with a password encoder,
 * and generates JWT tokens for authentication.
 * <p>
 * The class is annotated with {@code @Service}, making it a Spring-managed service
 * and {@code @Slf4j} for logging purposes. It employs dependency injection for required components.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserRecord createUser(CreateUserRecord userRecord) {
        User user = UserMapper.INSTANCE.recordToEntity(userRecord);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setStatus(UserStatus.ACTIVE);
//        user.setRequirePasswordChange(true);
//        user.setMfaEnabled(false);

        User createdUser = userRepository.save(user);
        log.debug("IN register -> User with email {} registered successfully", createdUser.getUsername());
        return UserMapper.INSTANCE.entityToRecord(createdUser);
    }

    public List<UserRecord> getAllUsers() {
        return UserMapper.INSTANCE.entityListToRecordList(userRepository.findAll());
    }

//    /**
//     * unique email == username for log-in
//     */
//    public UserEntity findByEmail(String email) {
//        UserEntity foundUser = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with the email %s not found", email)));
//        log.debug("IN findByName -> Found user by name {}", foundUser.getUsername());
//        return foundUser;
//    }

    public User findById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with the id %s not found", id)));
        log.debug("IN findById -> Found user by id {}", foundUser.getUsername());
        return foundUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.debug("IN deleteUser -> User with id {} deleted", id);
    }

    public UserRecord getCurrentUser(Long userId) {
        User user = findById(userId);
        return UserMapper.INSTANCE.entityToRecord(user);
    }

    @Override
    public LoginResponse authenticateUser(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser currentUser = (JwtUser) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(currentUser.getUsername());
        CurrentUserRecord currentUserRecord = UserMapper.INSTANCE.toCurrentUserRecord(currentUser);
        return new LoginResponse(token, currentUserRecord);
    }

    public UserRecord editUser(EditUserRecord userRecord) {
        User existingUser = findById(userRecord.id());

//        existingUser.setFirstname(userRecord.firstname());
//        existingUser.setLastname(userRecord.lastname());
//        existingUser.setEmail(userRecord.email());
//        existingUser.setRole(userRecord.role());

        User updatedUser = userRepository.save(existingUser);
        log.debug("IN editUser -> User with email {} updated successfully", updatedUser.getUsername());

        return UserMapper.INSTANCE.entityToRecord(updatedUser);
    }

}
