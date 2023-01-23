package com.cg.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jobportal.entity.BookmarkedJob;
import com.cg.jobportal.repository.BookmarkedJobRepository;

@Service
public class BookmarkedJobServiceImpl implements BookmarkedJobService{
	
	@Autowired
	private BookmarkedJobRepository bookRepo;
	
	@Override
	public BookmarkedJob saveJob(BookmarkedJob book) {
	return bookRepo.save(book);
	}

	@Override
	public List<BookmarkedJob> getAllBookmarkedJobs() {
		return bookRepo.findAll();
	}
	
	@Override
	public String deleteById(Long id) {
		bookRepo.deleteById(id);
		return "Bookmark deleted successfully";
	}

	@Override
	public BookmarkedJob getById(Long id) {
		 BookmarkedJob git = bookRepo.findById(id).get();
		 return git;
	}

}
