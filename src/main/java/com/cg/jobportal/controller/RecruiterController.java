

package com.cg.jobportal.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.jobportal.entity.Recruiter;
import com.cg.jobportal.exceptions.InvalidRecruiterException;
import com.cg.jobportal.exceptions.RecruiterAlreadyExistException;
import com.cg.jobportal.service.RecruiterService;

/***********************************************************************************************************************
 * @author vedavyas
 * @param id
 * @param recruiter
 * @throws InvalidRecruiterException 
 * Created Date: 23 January, 2023 
 * Description: This class is the controller for the Recruiter module
 ***********************************************************************************************************************/
@RequestMapping("/Recruiter")
@RestController
public class RecruiterController {

	@Autowired
	public RecruiterService recruiterService;

	/*********************************************************************************************************************
	 * @param recruiter
	 * @return: Response Entity of Object type
	 * @throws RecruiterAlreadyExistException
	 * @postmapping: Post mapping requests a body from the user which is then
	 *               persisted onto the database.
	 *********************************************************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<Recruiter> saveRecruiter(@RequestBody Recruiter recruiter)
			throws RecruiterAlreadyExistException {
		Recruiter save = recruiterService.saveRecruiter(recruiter);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Recruiter>> getAllRecruiters() {
		List<Recruiter> Recruiter = recruiterService.getAllRecruiters();
		return new ResponseEntity<>(Recruiter, HttpStatus.OK);
	}

	/**********************************************************************************************************************
	 * @param id
	 * @return: Response Entity of recruiter type 
	 * Description : This method finds a Recruiter by id
	 * @GetMapping: Get mapping expects a PathVariable to be passed which is then
	 *              used to return the entity object that is fetched from the
	 *              database.
	 **********************************************************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<Recruiter> getRecruiterById(@PathVariable long id) throws InvalidRecruiterException {
		Recruiter recruiter = recruiterService.getRecruiterById(id);
		return new ResponseEntity<>(recruiter, HttpStatus.OK);
	}

	
	



	/***********************************************************************************************************************
	 * @param id
	 * @return Response Entity of recruiter type
	 * @DeleteMapping: Delete mapping expects a PathVariable to be passed which is
	 *                 used to delete the object from the database.
	 **********************************************************************************************************************/
	@DeleteMapping("/deleteRecruiterId/{id}")

	public ResponseEntity<String> deleteById(@PathVariable long id) {
		String delete = recruiterService.deleteById(id);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

	/*********************************************************************************************************************
	 * @param id
	 * @param recruiter
	 * @return: Response Entity of Object type
	 * @throws InvalidRecruiterException 
	 * Description : This method updates the existing Recruiter Application.
	 * @putmapping: Put mapping requests a body from the user which is then
	 *              persisted onto the database.
	 ********************************************************************************************************************/
	@PutMapping("/updateRecruiter/{id}")
	public ResponseEntity<Recruiter> updateRecruiter(@PathVariable long id, @RequestBody Recruiter recruiter)
			throws InvalidRecruiterException {
		Recruiter update = recruiterService.updateRecruiter(id, recruiter);
		return new ResponseEntity<>(update, HttpStatus.ACCEPTED);

	}
}
