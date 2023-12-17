package com.linsglf.springmongodb.dto;

import com.linsglf.springmongodb.domain.User;

import java.io.Serializable;

public record UserDTO(String id, String name, String email) implements Serializable {
    private static final long serialVersionUID = 1L;

    public UserDTO(User obj) {
        this(obj.getId(), obj.getName(), obj.getEmail());
    }
}
