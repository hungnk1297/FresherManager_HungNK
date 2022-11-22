package com.vmo.fresher.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceInMemory implements UserDetailsService {

    private static final String ADMIN_ROLE = "Admin";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$fRBuVDEL.Ip26r59kFjxp..Vp83f5d8DJVStE2uAiW/2sDpOgmNei") // 123456
                .roles(ADMIN_ROLE)
                .build();

        if (username.equalsIgnoreCase(admin.getUsername())) {
            return admin;
        }
        return null;
    }
}
