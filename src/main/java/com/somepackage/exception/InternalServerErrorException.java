package com.somepackage.exception;

public class InternalServerErrorException extends RequestException {

    public InternalServerErrorException() {
        super(new ErrorMessage("Internal error occurred"));
    }

    public InternalServerErrorException(ErrorMessage errorMessage) {
        super(errorMessage);
    }


}
