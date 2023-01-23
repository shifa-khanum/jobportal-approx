package com.cg.jobportal.exceptions;

/*****************************************************
 * 
 * @author Arpitha
 * Created Date: 23 January, 2023 
 * Description: Invalid Feelancer Exception class
 *
 *****************************************************/

public class InvalidFreelancerException extends Exception{
	
	private String msg;

	public InvalidFreelancerException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidFreelancerException() {
		super();
	}

}
 
