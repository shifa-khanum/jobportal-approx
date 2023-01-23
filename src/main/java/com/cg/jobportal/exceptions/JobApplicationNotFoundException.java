package com.cg.jobportal.exceptions;

public class JobApplicationNotFoundException extends Exception {

	String msg;

	public JobApplicationNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public JobApplicationNotFoundException() {
		super();
	}
}
	
