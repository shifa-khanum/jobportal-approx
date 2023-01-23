package com.cg.jobportal.exceptions;
/**************************************************************************************
 * @author       Shifa Khanam Attar 
 * Description : This is bookmarked freelancer already exists exception  class . 
 * Created Date: 23 January, 2023 
 * 
 *************************************************************************************/
public class BookmarkedFreelancerAlreadyExistsException extends Exception{
	private String msg;

	public BookmarkedFreelancerAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public BookmarkedFreelancerAlreadyExistsException() {
		super();
	}
}
