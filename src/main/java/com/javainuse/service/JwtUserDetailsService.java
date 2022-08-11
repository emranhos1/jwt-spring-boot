package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javainuse.helper.constants.JwtAuthConstants;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (JwtAuthConstants.USERNAME.equals(username)) {
            return new User(JwtAuthConstants.USERNAME, JwtAuthConstants.PASSWORD, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException(JwtAuthConstants.USER_NOT_FOUND + username);
        }
    }

}