package com.somepackage.exception;

public class NotFoundException extends RequestException {

	public NotFoundException(ErrorMessage errorMessage) {
		super(errorMessage);
	}

	public NotFoundException(String message, Object... objects) {
		this(new ErrorMessage(message, objects));
	}

}
