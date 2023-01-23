package com.cg.jobportal.exceptions;

/***********************************************
 * 
 * @author Mohammed kather
 * Created Date: 23 January, 2023 
 * Description: Invalid Admin Exception class
 *
 ************************************************/
public class InvalidAdminException extends Exception{
	
	private String msg;

	public InvalidAdminException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidAdminException() {
		super();
	}

}
