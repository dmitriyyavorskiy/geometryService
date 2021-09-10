package com.somepackage.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RequestException {

    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public BadRequestException(String errorText, Object... objects) {
        super(new ErrorMessage(errorText, objects));
    }

}
