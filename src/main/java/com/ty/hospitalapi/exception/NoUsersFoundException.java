package com.ty.hospitalapi.exception;

public class NoUsersFoundException extends RuntimeException {

	private String message = "No user exists";

	public NoUsersFoundException() {

	}

	public NoUsersFoundException(String message) {
		this.message = message;

	}

	@Override
	public String getMessage() {
		return message;
	}
}
