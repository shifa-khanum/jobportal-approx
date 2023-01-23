package com.cg.jobportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jobportal.entity.Freelancer;
import com.cg.jobportal.exceptions.FreelancerAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidFreelancerException;
import com.cg.jobportal.repository.FreelancerRepository;

@Service
public class FreelancerServiceImpl implements FreelancerService {
    
	@Autowired
	private FreelancerRepository freelancerRepository;

	@Override
	public Freelancer saveFreelancer(Freelancer freelancer)throws FreelancerAlreadyExistException {
		if (freelancerRepository.existsById(freelancer.getId())) {
			throw new FreelancerAlreadyExistException();
		}
		return freelancerRepository.save(freelancer);
	}

	@Override
	public List<Freelancer> getAllFreelancer() {
		return freelancerRepository.findAll();
	}

	@Override
	public Freelancer getFreelancerById(long id) throws InvalidFreelancerException {
		if (freelancerRepository.existsById(id)) {
			return freelancerRepository.findById(id).get();
		} else {
			throw new InvalidFreelancerException();
		}
	}
	

	@Override
	public String deleteFreelancer(long id) {
		Optional<Freelancer> getId = freelancerRepository.findById(id);
		if(getId.isPresent()) {
			freelancerRepository.deleteById(id);
		}
		return "Freelancer Doesn't Exists";
	}

	
	@Override
	public Freelancer updateFreelancer(Freelancer freelancer) throws InvalidFreelancerException {
		if (freelancerRepository.existsById(freelancer.getId())) {
			return freelancerRepository.save(freelancer);
		}else {
			throw new InvalidFreelancerException();
		}
	}
		

	@Override
	public Freelancer FreelancerByUserName(String userName) {
		return freelancerRepository.findByUserName(userName);
	}
}
