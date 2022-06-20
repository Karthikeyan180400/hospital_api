package com.ty.hospitalapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.hospitalapi.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdFoundExceptionHandler(NoIdFoundException noIdFoundException) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(noIdFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = NotValidException.class)
	public ResponseEntity<ResponseStructure<String>> notValidExceptionHandler(
			NotValidException notValidException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(notValidException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = NoUsersFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noUsersFoundException(
			NoUsersFoundException noUsersFoundException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(noUsersFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

}
