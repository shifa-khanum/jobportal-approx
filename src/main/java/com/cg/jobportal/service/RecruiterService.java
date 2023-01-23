package com.cg.jobportal.service;

import java.util.List;
import java.util.Optional;

import com.cg.jobportal.entity.Recruiter;
import com.cg.jobportal.exceptions.InvalidRecruiterException;
import com.cg.jobportal.exceptions.RecruiterAlreadyExistException;

import jakarta.validation.Valid;

public interface RecruiterService {
	
	Recruiter saveRecruiter(@Valid Recruiter recruiter) throws RecruiterAlreadyExistException;
	
	List<Recruiter> getAllRecruiters();
	
	Recruiter getRecruiterById(long id) throws InvalidRecruiterException;
	
	String deleteById(long id);
	
	Recruiter updateRecruiter(long id,Recruiter recruiter) throws InvalidRecruiterException;

}
