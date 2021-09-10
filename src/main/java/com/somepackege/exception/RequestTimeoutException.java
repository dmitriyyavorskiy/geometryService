package com.somepackege.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequestTimeoutException extends RequestException {

    public RequestTimeoutException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public RequestTimeoutException(String message, Object... objects) {
        this(new ErrorMessage(message, objects));
    }
}
