package com.cg.jobportal.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.jobportal.entity.Job;

import com.cg.jobportal.exceptions.InvalidJobException;
import com.cg.jobportal.exceptions.JobAlreadyExistException;
import com.cg.jobportal.repository.JobRepository;


@Service
public class JobServiceImplementation implements JobService {
	
	
	@Autowired
	private JobRepository jobRepository;
	

	
	@Override
	public Job addjob(Job job)throws JobAlreadyExistException {
		if (jobRepository.existsById(job.getId())) {
			 throw new JobAlreadyExistException();
		}
		return jobRepository.save(job);
	}
	
	
	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}
	
	@Override
	public Job getById(long id) throws InvalidJobException{
		if(jobRepository.existsById(id)) {
		return jobRepository.findById(id).get();
	}else {
		throw new InvalidJobException();
	}
	}



    @Override
	public String deletejob(long id) {
		if (jobRepository.existsById(id)) {
             jobRepository.deleteById(id);
		}
		return "Doesn't Exists";
		
    }



}




