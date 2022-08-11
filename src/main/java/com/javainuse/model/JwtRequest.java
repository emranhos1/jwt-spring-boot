package com.javainuse.model;

import java.io.Serializable;

/**
 *
 * @author Md. Emran Hossain
 * @since 11 Aug, 2022
 * @version 1.1
 */
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String name;
    private Integer id;
    private Boolean validated;

    public JwtRequest(String name, Integer id, Boolean validated) {
        this.setName(name);
        this.setId(id);
        this.setValidated(validated);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public JwtRequest() { }
}