package com.javainuse.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.config.JwtTokenUtil;
import com.javainuse.helper.constants.JwtAuthConstants;
import com.javainuse.model.JwtRequest;
import com.javainuse.model.JwtResponse;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @PostMapping(JwtAuthConstants.AUTH)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getName(), authenticationRequest.getId(), authenticationRequest.getValidated());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getName());

        final String token = jwtTokenUtil.generateToken(userDetails, authenticationRequest);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, Integer password, Boolean validate) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception(JwtAuthConstants.USER_DISABLED, e);
        } catch (BadCredentialsException e) {
            throw new Exception(JwtAuthConstants.INVALID_CREDENTIALS, e);
        }
    }
}
