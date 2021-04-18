package com.company.exception;

public class UserHaveToManyBooksException extends ServerException {
    public UserHaveToManyBooksException() {
    }

    public UserHaveToManyBooksException(String message) {
        super(message);
    }

    public UserHaveToManyBooksException(String message, Throwable cause) {
        super(message, cause);
    }
}
