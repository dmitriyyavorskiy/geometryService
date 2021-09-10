package com.somepackage.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ForbiddenException extends RequestException {

    public ForbiddenException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public ForbiddenException(String message) {
        super(new ErrorMessage(message));
    }

    public ForbiddenException(String message, Object... objects) {
        super(new ErrorMessage(message, objects));
    }
}
