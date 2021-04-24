package com.company.exception;

public class UserDoesNotHaveThatLoyaltyCardException extends ServerException {
    public UserDoesNotHaveThatLoyaltyCardException() {
    }

    public UserDoesNotHaveThatLoyaltyCardException(String message) {
        super(message);
    }

    public UserDoesNotHaveThatLoyaltyCardException(String message, Throwable cause) {
        super(message, cause);
    }
}
