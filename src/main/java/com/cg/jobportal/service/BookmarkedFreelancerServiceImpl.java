package com.cg.jobportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jobportal.entity.BookmarkedFreelancer;
import com.cg.jobportal.exceptions.BookmarkedFreelancerAlreadyExistsException;
import com.cg.jobportal.exceptions.InvalidBookmarkedFreelancerException;
import com.cg.jobportal.repository.BookmarkedFreelancerRepository;



@Service
public class BookmarkedFreelancerServiceImpl implements BookmarkedFreelancerService {

	@Autowired
	private BookmarkedFreelancerRepository bookRepo;
	
	@Override
	public  BookmarkedFreelancer saveBookmarkedFreelancer(BookmarkedFreelancer bmark) throws BookmarkedFreelancerAlreadyExistsException{
		if(bookRepo.existsById(bmark.getId()))
			throw new BookmarkedFreelancerAlreadyExistsException();
		
		return bookRepo.save(bmark);
	}
	
	@Override
	public List<BookmarkedFreelancer> getAllBookmarkedFreelancer(){
		return bookRepo.findAll();
	}
	
	@Override
	public Optional<BookmarkedFreelancer> getBookmarkedFreelancerById(long id) throws InvalidBookmarkedFreelancerException{
		if(!bookRepo.existsById(id))
			throw new InvalidBookmarkedFreelancerException();
		return bookRepo.findById(id);
	}
	@Override
	public String deleteBookmarkedFreelancerById(long id) {
		Optional<BookmarkedFreelancer> free=bookRepo.findById(id);
		if(free.isPresent()) {
			bookRepo.deleteById(id);
			return "deleted successfully";
		}
		return "id doesn't exist";
	}
}
