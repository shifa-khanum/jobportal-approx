package com.cg.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jobportal.entity.JobApplication;
import com.cg.jobportal.exceptions.InvalidJobApplicationException;
import com.cg.jobportal.exceptions.JobApplicationAlreadyExistException;
import com.cg.jobportal.exceptions.JobApplicationNotFoundException;
import com.cg.jobportal.repository.JobApplicationRepository;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	
	
	
	@Autowired
	private JobApplicationRepository jobapplicationrepository;
	
	
	

	@Override
	public JobApplication applyToJob(JobApplication jobApplication) throws JobApplicationAlreadyExistException{
       if (jobapplicationrepository.existsById(jobApplication.getId())) {
    	   throw new JobApplicationAlreadyExistException();
       }
       
		return jobapplicationrepository.save(jobApplication);
	}
	
	

	@Override
	public List<JobApplication> findAll() {
		return jobapplicationrepository.findAll();
	}
	
	
	

	@Override
	public void remove(long id) throws JobApplicationNotFoundException {
		if (jobapplicationrepository.existsById(id)) {

			jobapplicationrepository.deleteById(id);
		} else
			throw new JobApplicationNotFoundException();
	}
	
	
	

	@Override
	public JobApplication updateJobApplication(long id, JobApplication jobApplication) throws InvalidJobApplicationException{
		if(jobapplicationrepository.existsById(id)) {
			return	jobapplicationrepository.save(jobApplication);	
		}else
			throw new InvalidJobApplicationException();

	}
	
	
}
