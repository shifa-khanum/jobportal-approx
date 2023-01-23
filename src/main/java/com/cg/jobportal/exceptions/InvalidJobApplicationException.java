package com.cg.jobportal.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Getter
@NoArgsConstructor
public class InvalidJobApplicationException extends Exception{


	private String msg;
}
