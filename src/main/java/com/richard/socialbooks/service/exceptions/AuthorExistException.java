package com.richard.socialbooks.service.exceptions;


public class AuthorExistException extends RuntimeException {

    public AuthorExistException(String message) {
        super(message);
    }

    public AuthorExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
