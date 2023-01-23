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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jobportal.entity.Freelancer;
import com.cg.jobportal.exceptions.FreelancerAlreadyExistException;
import com.cg.jobportal.exceptions.InvalidFreelancerException;
import com.cg.jobportal.service.FreelancerService;

@RequestMapping("/Freelancer")
@RestController
public class FreelancerController {

	@Autowired
	private FreelancerService freelancerService;
	/*****************************************************************************************
	 * Method      : saveFreelancer       
	 * @Param        freelancer
	 * @return       Response Entity of Object type
	 * Description : This method adds a new freelancer.
	 * @Postmapping: Post mapping requests a body from the user
	 * 				 which is then persisted onto the database.
	 ****************************************************************************************/
	@PostMapping("/save")



	 public ResponseEntity<Freelancer> saveFreelancer(@RequestBody Freelancer freelancer) throws FreelancerAlreadyExistException {

		Freelancer saved = freelancerService.saveFreelancer(freelancer);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	 }
	

	

	 @GetMapping("/all")
	 public ResponseEntity<List<Freelancer>> getAllFreelancer() {
		List<Freelancer> freelancer=freelancerService.getAllFreelancer();
		return new ResponseEntity<>(freelancer, HttpStatus.OK);
		 
	 }
	 /*****************************************************************************************
		 * Method      : getFreelancerById       
		 * @Param        id
		 * @return       Freelancer object
		 * Description : This method fetches a freelancer based on the unique id.
		 * @Getmapping : Get mapping expects a PathVariable to be passed 
		 *               which is then used to return the entity object 
		 *               that is fetched from the database.
		 ****************************************************************************************/
	 @GetMapping("/{id}")
	 public ResponseEntity<Freelancer> getFreelancerId(@PathVariable long id) throws InvalidFreelancerException{
		Freelancer freelancer=freelancerService.getFreelancerById(id);
		 return new ResponseEntity<>(freelancer, HttpStatus.OK);
		 
	 }

	 
	 @DeleteMapping("/delete")
	 public String deleteFreelancer(@RequestParam long id) {
		 freelancerService.deleteFreelancer(id);
		 return "Freelancer deleted successfully";

	 }
	 
	 
	 @PutMapping("/update")
	 public Freelancer updateStudent(@RequestBody Freelancer freelancer) throws InvalidFreelancerException {
		 return freelancerService.updateFreelancer(freelancer);
	 }
	 
	 @GetMapping("/Freelancer/{userName}")
	 public Freelancer getFreelancerByFirstName(@PathVariable String userName){
		 Freelancer list = freelancerService.FreelancerByUserName(userName);
		 return list;
	 }
}