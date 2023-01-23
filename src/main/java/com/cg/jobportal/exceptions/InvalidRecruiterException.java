package com.cg.jobportal.exceptions;

/*******************************************************
 * 
 * @author vedavyas
 * Created Date: 23 January, 2023 
 * Description: Invalid Recruiter Exception class
 *
 *******************************************************/

public class InvalidRecruiterException extends Exception {
	
	private String msg;

	public InvalidRecruiterException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidRecruiterException() {
		super();
	}

}
