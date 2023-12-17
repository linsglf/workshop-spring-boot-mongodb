package com.linsglf.springmongodb.dto;

import java.io.Serializable;
import java.util.Date;

public record CommentDTO(String text, Date date, AuthorDTO author) implements Serializable {
    private static final long serialVersionUID = 1L;
}
