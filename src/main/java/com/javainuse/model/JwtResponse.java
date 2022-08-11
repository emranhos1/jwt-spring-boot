package com.javainuse.model;

import java.io.Serializable;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}