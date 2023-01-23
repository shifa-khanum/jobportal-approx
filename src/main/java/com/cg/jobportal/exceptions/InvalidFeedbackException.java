package com.cg.jobportal.exceptions;

/****************************************************
 * 
 * @author Mohammed Kather
 * Created Date: 23 January, 2023 
 * Description: Invalid Feedback Exception class
 *
 *****************************************************/
public class InvalidFeedbackException extends Exception {
	private String msg;

	public InvalidFeedbackException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidFeedbackException() {
		super();
	}

}
