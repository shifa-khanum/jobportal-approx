package com.cg.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.jobportal.entity.BookmarkedJob;
import com.cg.jobportal.service.BookmarkedJobService;
@RequestMapping("/Bookmarkedjob")
@RestController
public class BookmarkedJobController {
	
	@Autowired
	public BookmarkedJobService bookJobServ;
	/**
	 * 
	 * Method     : saveJobo
	 * @Param       bookmarkedJob
	 * @return      ResponseEntity
	 * Description: This method request for the data, checks validation of the data and creates bookmark for job.
	 * @PostMapping: This annotation handles with http post requests matched with the given url expression.  
	 */
	@PostMapping("/save")
	public ResponseEntity<BookmarkedJob> saveJob(@RequestBody BookmarkedJob book){
		BookmarkedJob savedJob = bookJobServ.saveJob(book);
		return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BookmarkedJob>> getAllBookmarkedJob(){
		List<BookmarkedJob> bookmark=bookJobServ.getAllBookmarkedJobs();
		return new ResponseEntity<>(bookmark, HttpStatus.OK);
	}
	/**
	 * 
	 * Method     : deleteBookmarkById
	 * @Param       deletebookmarkedjob
	 * @throws      BookmarkedJobValidationException
	 * @return      ResponseEntity
	 * @DeleteMapping: Delete mapping expects a PathVariable to be passed 
	 *                 which is used to delete the object from the database.  
	 */
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteBookmarkById(@PathVariable Long id) {
		String delete = bookJobServ.deleteById(id);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method      : getById       
	 * @Param        Id
	 * @return       Response Entity of Object type
	 * Description : This method fetches a Bookmarked Job based on the unique id
	 * @Getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ************************************************************************************/
	@GetMapping("/get/id/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
			BookmarkedJob bookmarkedJob = bookJobServ.getById(id);
			return new ResponseEntity<>(bookmarkedJob, HttpStatus.OK);
	}
	
}
