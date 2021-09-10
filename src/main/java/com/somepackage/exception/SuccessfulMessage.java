package com.somepackage.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SuccessfulMessage {

	@JsonProperty
	private String message;

	@JsonProperty("id")
	private Long objectId;

	@JsonProperty
	private Object object;

	public SuccessfulMessage(String message, Object... objects) {
		this.message = String.format(message, objects);
	}

}
