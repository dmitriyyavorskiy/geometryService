package com.somepackege.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotAcceptableException extends RequestException {

	public NotAcceptableException(ErrorMessage errorMessage) {
		super(errorMessage);
	}

}
