package com.cg.jobportal.exceptions;

/************************************************************
 * 
 * @author sangeetha
 * Created Date: 23 January, 2023 
 * Description: Invalid Skill Experience Exception class
 *
 ************************************************************/

public class InvalidSkillExperienceException extends RuntimeException{
	public InvalidSkillExperienceException(){
		super();
	}
	public InvalidSkillExperienceException(String message) {
		super(message);
	}
	

}
