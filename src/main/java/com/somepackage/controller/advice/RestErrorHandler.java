package com.somepackage.controller.advice;

import com.somepackage.exception.ErrorMessage;
import com.somepackage.exception.RequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestErrorHandler {

    @ExceptionHandler(RequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage processBadRequestException(RequestException e) {
        log.error("Bad request %s", e.getErrorMessage());
        return e.getErrorMessage();
    }
}
