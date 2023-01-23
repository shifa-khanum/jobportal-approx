package com.cg.jobportal.exceptions;

/************************************************************
 * 
 * @author vedavyas
 * Created Date: 23 January, 2023 
 * Description: Recruiter Already Exist Exception class
 *
 ************************************************************/
public class RecruiterAlreadyExistException extends Exception {
	private String msg;

	public RecruiterAlreadyExistException(String msg) {
		super();
		this.msg = msg;
	}

	public RecruiterAlreadyExistException() {
		super();
	}
	
	
}
