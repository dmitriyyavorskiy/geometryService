package com.somepackege.controller.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.somepackege.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ValidationErrorHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> process(MethodArgumentNotValidException ex, HttpServletRequest request) {
		log.error("Validation Error in request %s", request.getRequestURL());
		BindingResult result = ex.getBindingResult();
		Map<String, String> validationErrors = processFieldErrors(result.getFieldErrors());
		log.error("Validation Errors: %s", validationErrors);
		return validationErrors;
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> process(ValidationException ex, HttpServletRequest request) {
		log.error("Validation exception in request %s for field %s with error %s", request.getRequestURL(), ex.getField(), ex.getMessage());
		Map<String, String> validationErrors = new HashMap<>();
		//todo: fix: ValidationException has constr. which does not req. field and getField may return null
		validationErrors.put(ex.getField(), ex.getMessage());
		return validationErrors;
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationException process(UnexpectedTypeException ex, HttpServletRequest request) {
		log.error("UnexpectedTypeException Error in request %s with error %s", request.getRequestURL(), ex.getMessage());
		return new ValidationException("", ex.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationException process(IllegalArgumentException ex, HttpServletRequest request) {
		log.error("IllegalArgument Error in request %s with error %s", request.getRequestURL(), ex.getMessage());
		return new ValidationException("", ex.getMessage());
	}

	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationException process(InvalidFormatException ex, HttpServletRequest request) {
		log.error("Invalid Format Exception in request %s with error %s", request.getRequestURL(), ex.getMessage());
		return new ValidationException("", ex.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage process(BadRequestException e) {
		log.error("Bad request %s", e.getErrorMessage());
		return e.getErrorMessage();
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage process(NotFoundException e) {
		log.error("not found %s", e.getErrorMessage());
		return e.getErrorMessage();
	}

	@ExceptionHandler(ForbiddenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessage process(ForbiddenException e) {
		log.error("Bad request %s", e.getErrorMessage());
		return e.getErrorMessage();
	}

	@ExceptionHandler(NotAcceptableException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ErrorMessage process(NotAcceptableException e) {
		log.error("Not acceptable %s", e.getErrorMessage());
		return e.getErrorMessage();
	}

	@ExceptionHandler(NotModifiedException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public ErrorMessage process(NotModifiedException e) {
		return e.getErrorMessage();
	}

	@ExceptionHandler(InternalServerErrorException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage process(InternalServerErrorException e) {
		log.error("Internal server error %s", e.getErrorMessage());
		return e.getErrorMessage();
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage process(MaxUploadSizeExceededException e) {
		return new ErrorMessage(ValidationConstants.MAXIMUM_UPLOAD_SIZE_EXCEEDED_MESSAGE);
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage process(IllegalStateException e) {
		return new ErrorMessage(ValidationConstants.MAXIMUM_UPLOAD_SIZE_EXCEEDED_MESSAGE);
	}

	private Map<String, String> processFieldErrors(List<FieldError> fieldErrors) {
		Map<String, String> validationErrors = new HashMap<>();
		for (FieldError fieldError : fieldErrors) {
			ValidationException exception = resolveValidationError(fieldError);
			String field = exception.getField();

			// set proper field name for polygons
			if (field.contains(".coordinates[0]")){
				field = field.replace(".coordinates[0]", "");
			}

			validationErrors.put(field, exception.getMessage());
		}
		return validationErrors;
	}

	private ValidationException resolveValidationError(FieldError fieldError) {
		return new ValidationException(fieldError.getField(), fieldError.getDefaultMessage());
	}
}
