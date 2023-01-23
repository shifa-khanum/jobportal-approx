package com.cg.jobportal.controller;

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

import com.cg.jobportal.entity.Job;
import com.cg.jobportal.exceptions.InvalidJobException;
import com.cg.jobportal.exceptions.JobAlreadyExistException;
import com.cg.jobportal.service.JobService;



/************************************************************************************
 * @author sahana
 * Created Date: 23 January, 2023 
 * Description: This class is the controller for the job module
 ************************************************************************************/

@RequestMapping("/Job")

@RestController
public class JobController {
	
	
	@Autowired
	private JobService jobService; 
	

	/*******************************************************************************************
	 * @param job
	 * @return       Response Entity of Object type
	 * Description : This method posts a new job.
	 * @PostMapping: Annotation for mapping HTTP POST requests onto specific handler methods.
	 *******************************************************************************************/
	

	
	
	@PostMapping("/post")
	public ResponseEntity<Object> job(@RequestBody Job job)throws JobAlreadyExistException  {
		jobService.addjob(job);

		return new ResponseEntity<>("Job Posted Successfully", HttpStatus.OK);
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
	}
	

	/*********************************************************************************************
	 * @param id
	 * @return       Response Entity of Job type
	 * Description : This method finds a job by id
	 * @GetMapping: Annotation for mapping HTTP GET requests onto specific handler methods.
	 **********************************************************************************************/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id)throws InvalidJobException {
			return new ResponseEntity<>(jobService.getById(id), HttpStatus.OK);
	}

	/**********************************************************************************************
	 * @param id
	 * @return  Response Entity of Job type
	 * @DeleteMapping: Annotation for mapping HTTP GET requests onto specific handler methods.
	 **********************************************************************************************/
	
	@DeleteMapping("/{id}")

	public ResponseEntity<Object> deletejob(@PathVariable long id) {
			jobService.deletejob(id);
		return new ResponseEntity<>("deleted successfully", HttpStatus.OK);

	}
}
