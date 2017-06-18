package com.richard.socialbooks.service.exceptions;


public class BookFoundException extends RuntimeException {

    public BookFoundException(String message) {
        super(message);
    }

    public BookFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
