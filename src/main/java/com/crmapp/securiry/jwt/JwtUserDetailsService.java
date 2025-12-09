package com.crmapp.securiry.jwt;

import com.crmapp.user.UserEntity;
import com.crmapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with the email %s not found", username)));
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN JwtUserDetailsService loadUserByUsername -> User {} loaded successfully ", username);
        return jwtUser;
    }
}
