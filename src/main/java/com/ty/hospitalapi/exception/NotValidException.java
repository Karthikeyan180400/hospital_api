package com.ty.hospitalapi.exception;

public class NotValidException extends RuntimeException {
	private String message = "User Not Valid";

	public NotValidException() {
	}

	public NotValidException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
