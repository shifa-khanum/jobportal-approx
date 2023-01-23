package com.cg.jobportal.exceptions;

/****************************************************************
 * 
 * @author Shifa Khanum
 * Created Date: 23 January, 2023 
 * Description: Invalid Bookmarked Freelancer Exception class
 *
 ****************************************************************/
public class InvalidBookmarkedFreelancerException extends Exception{
	
	private String msg;

	
	public InvalidBookmarkedFreelancerException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidBookmarkedFreelancerException() {
		super();
	}
}
