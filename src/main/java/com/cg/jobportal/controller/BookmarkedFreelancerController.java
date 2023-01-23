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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.jobportal.entity.BookmarkedFreelancer;
import com.cg.jobportal.exceptions.BookmarkedFreelancerAlreadyExistsException;
import com.cg.jobportal.exceptions.InvalidBookmarkedFreelancerException;
import com.cg.jobportal.service.BookmarkedFreelancerService;
/**************************************************************************************
 * @author Shifa Khanam Attar
 * Description: This is the rest controller class for BookmarkedFreelancer module. 
 * Created Date: 23 January, 2023 

 *************************************************************************************/

@RequestMapping("/bmark/freelancer")
@RestController
public class BookmarkedFreelancerController {
	
	@Autowired
	BookmarkedFreelancerService bookmarkfreeService;
	/*****************************************************************************************
	 * Method      : createBookmark       
	 * @Param        bookmarkedFreelancer
	 * @throws       The method throws different exceptions based on improperly entered fields
	 * @return       Response Entity of Object type
	 * Description : This method creates a new Bookmark of a freelancer.
	 * @Postmapping: Post mapping requests a body from the user
	 * 				 which is then persisted onto the database.
	 ****************************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<BookmarkedFreelancer> saveBookmarkedFreelancer(@RequestBody BookmarkedFreelancer bmark)throws BookmarkedFreelancerAlreadyExistsException {
		BookmarkedFreelancer savedBookmarkedFreelancer=bookmarkfreeService.saveBookmarkedFreelancer(bmark);
		return new ResponseEntity<>(savedBookmarkedFreelancer, HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<BookmarkedFreelancer>> getAllBookmarkedFreelancer(){
		List<BookmarkedFreelancer> allBookmarkedFreelancer = bookmarkfreeService.getAllBookmarkedFreelancer();
		return new ResponseEntity<>(allBookmarkedFreelancer, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method      : getBookmarkedFreelancerById       
	 * @Param        Id
	 * @return       Response Entity of Object type
	 * Description : This method fetches a Bookmarked Freelancer based on the unique id
	 * @Getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ************************************************************************************/
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<BookmarkedFreelancer>> getBookmarkedFreelancerById(@PathVariable long id) throws InvalidBookmarkedFreelancerException{
		Optional<BookmarkedFreelancer> bmarkfreelancer=bookmarkfreeService.getBookmarkedFreelancerById(id);
		return new ResponseEntity<>(bmarkfreelancer, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method      : deleteBookmarkedFreelancerById       
	 * @Param        Id
	 * @return       Response Entity of Object type
	 * Description : This method deletes a Bookmarked Freelancer based on the unique id
	 * @Deletemapping : Delete mapping expects a PathVariable to be passed 
	 *                 which is used to delete the object from the database.
	 ************************************************************************************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  deleteBookmarkedFreelancerById(@PathVariable long id) {
		String msg=bookmarkfreeService.deleteBookmarkedFreelancerById(id);
		return new ResponseEntity<>(msg, HttpStatus.OK); 
	}
}
