package com.orderApplication.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.orderApplication.controller.OrderController;
import com.orderApplication.payload.ErrorResponse;

@SuppressWarnings("serial")
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);

	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	//Map<String, String> errorsFields = new HashMap<>();

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(final MethodArgumentNotValidException pException) {
        final List<Map<String, String>> lFiledValidationErrors = pException.getBindingResult().getAllErrors().stream()
        		.filter(FieldError.class::isInstance).map(FieldError.class::cast).map(lFieldError -> {
                    final Map<String, String> lErrorsMap = new HashMap<>();
                    lErrorsMap.put(lFieldError.getField(), lFieldError.getDefaultMessage());
                    return lErrorsMap;
                }).toList();
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(false, "validation errors", lFiledValidationErrors),
                HttpStatus.BAD_GATEWAY);
	}
	
	                    
	  
	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<ErrorResponse>
	 * customeExceptionHandler(MethodArgumentNotValidException exception) { //
	 * logger.error("exception" + ((ErrorResponse)
	 * exception).getDetailMessageCode());
	 * 
	 * exception.getBindingResult().getFieldErrors() .forEach(error ->
	 * errorsFields.put(error.getField(), error.getDefaultMessage()));
	 * 
	 * return new ResponseEntity<ErrorResponse>(new ErrorResponse(false,
	 * "validation error", errorsFields), HttpStatus.BAD_REQUEST); }
	 */
		 

	@ExceptionHandler(OrderAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> orderalredyExists(OrderAlreadyExistsException exception) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(false, exception.getMessage(), null));
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