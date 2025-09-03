package com.debasish.exception;

@SuppressWarnings("serial")
public class StudentNotFoundByIdException extends RuntimeException {

	private String message;
	
	public StudentNotFoundByIdException(String message) {
		super();
		this.message=message;
	}
	public String getMessaage() {
		return message;
		
	}
	public void setMessage(String message) {
		this.message=message;
	}
}
