package com.cg.jobportal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.jobportal.entity.Feedback;
import com.cg.jobportal.exceptions.InvalidFeedbackException;
import com.cg.jobportal.service.FeedbackService;

@RequestMapping("/Feedback")
@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;

	/*****************************************************************************************
	 * Method      : addFeedback       
	 * @Param        feedback
	 * @return       Response Entity of Object type
	 * Description : This method adds a new feedback.
	 * @Postmapping: Post mapping requests a body from the user
	 * 				 which is then persisted onto the database.
	 ****************************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
		Feedback save=feedbackService.addFeedback(feedback);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Feedback>> getAllFeedbacks(){
		List<Feedback> Feedbacks=feedbackService.getAllFeedbacks();
		return new ResponseEntity<>(Feedbacks, HttpStatus.OK);
	}
	/************************************************************************************
	 * Method      : getFeedbackById       
	 * @Param        Id
	 * @return       Response Entity of Object type
	 * Description : This method fetches a feedback based on the unique id
	 * @Getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ************************************************************************************/
	
	@GetMapping("/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable long id) throws InvalidFeedbackException{
		Feedback admin=feedbackService.getFeedbackById(id);
		return new ResponseEntity<>(admin, HttpStatus.OK);
		
	}
	/************************************************************************************
	 * Method      : updateFeedback       
	 * @Param        Id
	 * @return       Response Entity of Object type
	 * Description : This method updates a Feedback based on the unique id
	 * @Putmapping : Put mapping is used for handling the incoming put requests from the client side.
	 ************************************************************************************/
	@PutMapping("/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable long id, @RequestBody Feedback feedback) throws InvalidFeedbackException {
		Feedback update=feedbackService.updateFeedback(id,feedback);
		return new ResponseEntity<>(update, HttpStatus.ACCEPTED);
		
	}
}
