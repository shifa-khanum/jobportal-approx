package com.cg.jobportal.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationAlreadyExistException extends Exception {
	
	private String msg;

}
