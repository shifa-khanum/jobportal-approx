package com.cg.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jobportal.entity.JobApplication;
import com.cg.jobportal.exceptions.InvalidJobApplicationException;
import com.cg.jobportal.exceptions.JobApplicationAlreadyExistException;
import com.cg.jobportal.exceptions.JobApplicationNotFoundException;
import com.cg.jobportal.service.JobApplicationService;
import jakarta.validation.Valid;


/****************************************************************************************************
 * @author sahana
 * Created Date: 23 January, 2023 
 * Description: This is the rest controller class for JobApplication module.
 ***************************************************************************************************/

@RequestMapping("/JobApplication")

@RestController
public class JobApplicationController {

	
	@Autowired
	private JobApplicationService jobApplicationService;


	/**************************************************************************************************
	 * Method      : applyToJob
	 * @param jobApplication
	 * @return Response Entity of Object type
	 * @postmapping: Post mapping requests a body from the user
	 * 				 which is then persisted onto the database.
	 **************************************************************************************************/
	

	@PostMapping(value = "/apply")
	public ResponseEntity<String> applyToJob(@RequestBody JobApplication jobApplication)throws JobApplicationAlreadyExistException {
		       jobApplicationService.applyToJob(jobApplication);

		return new ResponseEntity<>("Job Applied Successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<JobApplication>> findAll() {
		return new ResponseEntity<>(jobApplicationService.findAll(), HttpStatus.OK);
	}

	
	/********************************************************************************************
	 * Method:  deleteById       
	 * @param   id
	 * @throws  NoElementFoundException
	 * @return  Response Entity of Object type
	 * Description: This method deletes a Job Application by id 
	 * @deletemapping: Delete mapping expects a PathVariable to be passed 
	 *                 which is used to delete the object from the database.
	 ********************************************************************************************/
	


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> remove(@Valid @PathVariable long id) throws JobApplicationNotFoundException {
		jobApplicationService.remove(id);
		return new ResponseEntity<>("job application deleted successfully", HttpStatus.OK);
	}


	/********************************************************************************************
	 * Method      : updateJobApplication
	 * @param id
	 * @param jobApplication
	 * @return Response Entity of Object type
	 * Description : This method updates the existing Job Application.
	 * @putmapping: Put mapping requests a body from the user
	 * 				 which is then persisted onto the database.
	 *********************************************************************************************/

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateJobApplication(@Valid @PathVariable long id,@RequestBody JobApplication jobApplication)throws InvalidJobApplicationException {

		jobApplicationService.updateJobApplication(id, jobApplication);
		return new ResponseEntity<>("job application updated successfully", HttpStatus.OK);
	}
}
