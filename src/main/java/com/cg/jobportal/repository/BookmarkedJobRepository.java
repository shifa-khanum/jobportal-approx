package com.cg.jobportal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jobportal.entity.BookmarkedJob;
@Repository
public interface BookmarkedJobRepository extends JpaRepository<BookmarkedJob, Long> {


	BookmarkedJob save(BookmarkedJob book);
	
	List<BookmarkedJob> findAll();
	
	
}






