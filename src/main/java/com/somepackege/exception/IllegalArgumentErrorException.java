package com.somepackege.exception;

public class IllegalArgumentErrorException extends IllegalArgumentException {

    public IllegalArgumentErrorException(String message, Object... args) {
        super(String.format(message, args));
    }
}
