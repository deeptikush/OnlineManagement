package com.orderApplication.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;
import java.util.HashMap;
import com.orderApplication.controller.OrderController;
import com.orderApplication.payload.ApiResponse;
import com.orderApplication.payload.ErrorMessage;

@SuppressWarnings("serial")
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);

	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	Map<String, String> errorsFields = new HashMap<>();

	@ExceptionHandler(Exception.class)

	public ResponseEntity<ErrorMessage> customeExceptionHandler(MethodArgumentNotValidException exception) {
		logger.error("exception" + ((ErrorResponse) exception).getDetailMessageCode());

		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errorsFields.put(error.getField(), error.getDefaultMessage()));

		return new ResponseEntity<ErrorMessage>(new ErrorMessage(false, "validation error", errorsFields),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderAlreadyExists.class)

	public ResponseEntity<ApiResponse> orderalredyExists(OrderAlreadyExists orderAlreadyExists) {

		// return new ResponseEntity<ErrorMessage>(new ErrorMessage(false, "order alredy
		// exists",errorsFields), HttpStatus.BAD_REQUEST);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, "order alredy exists"));
	}

}

/*
 * final List<Map<String, String>> fieldOfValidationErrors =
 * exception.getBindingResult().getAllErrors().stream()
 * .filter(FieldError.class::isInstance).map(FieldError.class::cast).map(
 * FieldError -> { final Map<String, String> errorMap = new HashMap<>();
 * errorMap.put(FieldError.getField(), FieldError.getDefaultMessage()); return
 * errorMap; }).toList(); return new ResponseEntity<ErrorMessage>(new
 * ErrorMessage(false, "validation error", errorsFields),
 * HttpStatus.BAD_GATEWAY);
 */