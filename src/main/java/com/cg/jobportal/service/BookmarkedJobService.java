package com.cg.jobportal.service;

import java.util.List;

import com.cg.jobportal.entity.BookmarkedJob;

public interface BookmarkedJobService {

	BookmarkedJob saveJob(BookmarkedJob book);

	List<BookmarkedJob> getAllBookmarkedJobs();

	String deleteById(Long id);

	BookmarkedJob getById(Long id);

}
