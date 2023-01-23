package com.cg.jobportal.exceptions;

/****************************************************
 * 
 * @author sangeetha
 * Created Date: 23 January, 2023 
 * Description: Invalid Skill Exception class
 *
 ****************************************************/
public class InvalidSkillException extends Exception{
	private String msg;

	public InvalidSkillException(String msg) {
		super();
		this.msg = msg;
	}

	public InvalidSkillException() {
		super();
	}
	

}
