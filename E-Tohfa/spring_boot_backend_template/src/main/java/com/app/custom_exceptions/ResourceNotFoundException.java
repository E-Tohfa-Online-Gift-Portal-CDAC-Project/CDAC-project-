package com.app.custom_exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String errMesg) {
		super(errMesg);
	}
	
	public ResourceNotFoundException(String errMesg, String string, Long categoryId) {
		super(errMesg);
	}
}
