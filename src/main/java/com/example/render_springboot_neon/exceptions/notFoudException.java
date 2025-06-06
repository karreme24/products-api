package com.example.render_springboot_neon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notFoudException extends RuntimeException {

    public notFoudException(String message) {
        super(message);
    }
}
