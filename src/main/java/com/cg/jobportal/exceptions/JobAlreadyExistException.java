package com.cg.jobportal.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JobAlreadyExistException extends Exception{

	private String msg;

}
