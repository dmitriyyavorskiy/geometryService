package com.somepackege.exception;

public class NotModifiedException extends RequestException {

	public NotModifiedException(ErrorMessage errorMessage) {
		super(errorMessage);
	}

}
