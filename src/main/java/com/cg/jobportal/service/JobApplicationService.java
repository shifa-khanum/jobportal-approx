package com.cg.jobportal.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.cg.jobportal.entity.JobApplication;
import com.cg.jobportal.exceptions.InvalidJobApplicationException;
import com.cg.jobportal.exceptions.JobApplicationAlreadyExistException;
import com.cg.jobportal.exceptions.JobApplicationNotFoundException;

import jakarta.validation.Valid;



@Validated
public interface JobApplicationService  {

	JobApplication applyToJob(@Valid JobApplication jobApplication) throws JobApplicationAlreadyExistException;

	List<JobApplication> findAll();

	void remove(long id) throws JobApplicationNotFoundException;
	
	JobApplication updateJobApplication(long id,JobApplication jobApplication) throws InvalidJobApplicationException;
	



	
}
