package com.somepackage.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class RequestException extends Exception {

	@JsonProperty
	protected ErrorMessage errorMessage;
    
    public RequestException(ErrorMessage errorMessage) {
    	this.errorMessage = errorMessage;
    }

}
