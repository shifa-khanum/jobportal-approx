package com.cg.jobportal.exceptions;

public class BookmarkedJobAlreadyExistException extends Exception {
	
	private String msg;

	public BookmarkedJobAlreadyExistException(String msg) {
		super();
		this.msg = msg;
	}

	public BookmarkedJobAlreadyExistException() {
		super();
	}
	

}
