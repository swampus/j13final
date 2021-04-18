package com.company.exception;

public class UserDoesNotHaveThatBookException extends ServerException {
    public UserDoesNotHaveThatBookException() {
    }

    public UserDoesNotHaveThatBookException(String message) {
        super(message);
    }

    public UserDoesNotHaveThatBookException(String message, Throwable cause) {
        super(message, cause);
    }
}
