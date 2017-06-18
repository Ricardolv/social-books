package com.richard.socialbooks.service.exceptions;


public class AuthorFoundException extends RuntimeException {

    public AuthorFoundException(String message) {
        super(message);
    }

    public AuthorFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
