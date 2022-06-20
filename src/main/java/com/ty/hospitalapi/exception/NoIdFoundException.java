package com.ty.hospitalapi.exception;

public class NoIdFoundException extends RuntimeException {

	private String message = "ID is not exist";

	public NoIdFoundException() {

	}

	public NoIdFoundException(String message) {
		this.message = message;

	}

	@Override
	public String getMessage() {
		return message;
	}
}
