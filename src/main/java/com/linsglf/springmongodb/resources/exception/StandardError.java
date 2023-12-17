package com.linsglf.springmongodb.resources.exception;

import java.io.Serializable;

public record StandardError(Long timestamp, Integer status, String error, String message, String path) implements Serializable {
    private static final long serialVersionUID = 1L;
}
