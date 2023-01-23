package com.cg.jobportal.service;
import java.util.List;
import java.util.Optional;

import com.cg.jobportal.entity.Freelancer;
import com.cg.jobportal.exceptions.FreelancerAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidFreelancerException;



public interface FreelancerService {

	Freelancer saveFreelancer(Freelancer freelancer) throws FreelancerAlreadyExistException;

	List<Freelancer> getAllFreelancer();

	Freelancer getFreelancerById(long id) throws InvalidFreelancerException;

	String deleteFreelancer(long id);

	Freelancer updateFreelancer(Freelancer freelancer) throws InvalidFreelancerException;

	Freelancer FreelancerByUserName(String userName);

	
}
