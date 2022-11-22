package com.vmo.fresher.controller;

import com.vmo.fresher.exception.ApiErrorDetail;
import com.vmo.fresher.exception.InvalidLoginCredentialException;
import com.vmo.fresher.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import model.request.JwtRequest;
import model.response.JwtResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid JwtRequest loginRequest) {

        var user = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            final String jwt = jwtUtil.generateJwtToken(loginRequest.getUsername());
            List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

            return ResponseEntity.ok(JwtResponse.builder().token(jwt).username(user.getUsername()).roles(roles).build());
        }
        throw new InvalidLoginCredentialException(ApiErrorDetail.builder().message("Invalid login credential!").httpStatus(HttpStatus.BAD_REQUEST).build());
    }
}
