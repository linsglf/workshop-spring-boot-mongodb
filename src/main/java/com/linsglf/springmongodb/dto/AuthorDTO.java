package com.linsglf.springmongodb.dto;

import com.linsglf.springmongodb.domain.User;

import java.io.Serializable;

public record AuthorDTO(String id, String name) implements Serializable {
    private static final long serialVersionUID = 1L;

    public AuthorDTO(User obj) {
        this(obj.getId(), obj.getName());
    }
}
