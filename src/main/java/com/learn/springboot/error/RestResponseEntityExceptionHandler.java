package com.learn.springboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/* Don't extend ResponseEntityExceptionHandler if you don't want to override all the exceptions (handleHttpRequestMethodNotSupported,MethodArgumentNotValidException,MissingPathVariableException,
 * NoHandlerFoundException etc.) it provides because for all these exceptions you won't get response body (only status code) as they are handled WITHOUT the response body. 
 * A common method is invoked: handleExceptionInternal(ex, null, headers, status, request), where second parameter is body which is null.
 * These exceptions are spring default/internal exceptions for which you may want to have a response body */

@ControllerAdvice // currently handle exceptions of all controllers, can be restricted to specific controller/package
@ResponseStatus
public class RestResponseEntityExceptionHandler {
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// Need to override when extending ResponseEntityExceptionHandler to show HttpRequestMethodNotSupported exception in our custom format
//	@Override
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		Error error = Error.builder()
//				.status(HttpStatus.METHOD_NOT_ALLOWED)
//				.message(ex.getMessage())
//				.fix("Please provide a valid method for request")
//				.build();
//		
//		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
//				.body(error);
//	}

	
	// Need to override when extending ResponseEntityExceptionHandler to show MethodArgumentNotValidException exception in our custom format
//	@Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException exception,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//		
//		List<FieldError> errors = exception.getFieldErrors();
//        List<String> message = new ArrayList<>();
//        
//        for (FieldError e : errors){
//            message.add(e.getDefaultMessage());
//        }
//
//		Error error = Error.builder()
//				.status(HttpStatus.BAD_REQUEST)
//				.message(message.toString())
//				.fix("Please provide a valid request body")
//				.build();
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//				.body(error);
//    }
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

	@ExceptionHandler(DepartmentNotFoundException.class) // this method will handle DepartmentNotFoundException occurring in controller
	public ResponseEntity<Error> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request) { // two injected input parameters - original exception and web request
		Error error = Error.builder()
				.status(HttpStatus.NOT_FOUND)
				.message(exception.getMessage())
				.fix("Please provide a valid department id")
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class) // this method will handle HttpRequestMethodNotSupportedException occurring in controller
	public ResponseEntity<Error> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception, WebRequest request) { // two injected input parameters - original exception and web request
		Error error = Error.builder()
				.status(HttpStatus.METHOD_NOT_ALLOWED)
				.message(exception.getMessage())
				.fix("Please provide a valid method for request")
				.build();
		
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
				.body(error);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Please provide a valid path parameter. Parameter type should be valid");
	}
	
}
