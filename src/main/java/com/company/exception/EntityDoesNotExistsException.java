package com.company.exception;

public class EntityDoesNotExistsException extends ServerException {
    public EntityDoesNotExistsException() {
        super();
    }

    public EntityDoesNotExistsException(String message) {
        super(message);
    }

    public EntityDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
