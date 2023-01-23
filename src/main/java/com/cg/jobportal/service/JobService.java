package com.cg.jobportal.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.cg.jobportal.entity.Job;
import com.cg.jobportal.exceptions.InvalidJobException;
import com.cg.jobportal.exceptions.JobAlreadyExistException;

import jakarta.validation.Valid;

@Validated
public interface JobService {

	
	Job addjob(@Valid Job job) throws JobAlreadyExistException;
	
	List<Job> findAll();
	
	Job getById(long id) throws InvalidJobException;
	
	String deletejob(long id);
	
	
}
