package com.cg.jobportal.exceptions;
/**************************************************************************************
 * @author       Team
 * Description : This is the Global Exception Handler class. 
 * Created Date: 23 January, 2023 
 * 
 *************************************************************************************/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AdminAlreadyExistException.class)
	public ResponseEntity<String> adminAlreadyExistException(AdminAlreadyExistException msg) {
		return new ResponseEntity<String>("Admin Already Exist,Please Try Again.", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = RecruiterAlreadyExistException.class)
	public ResponseEntity<String> RecruiterAlreadyExistException(RecruiterAlreadyExistException user) {
		return new ResponseEntity<String>("Recruiter already exist", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = BookmarkedFreelancerAlreadyExistsException.class)
	public ResponseEntity<String> BookmarkedFreelancerAlreadyExistsException(
			BookmarkedFreelancerAlreadyExistsException msg) {
		return new ResponseEntity<String>("Bookmarked freelancer already exists, please try with another freelancer",
				HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = InvalidBookmarkedFreelancerException.class)
	public ResponseEntity<String> InvalidBookmarkedFreelancerException(InvalidBookmarkedFreelancerException msg) {
		return new ResponseEntity<String>(" No bookmarked freelancer exists", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = InvalidAdminException.class)
	public ResponseEntity<String> invalidAdminException(InvalidAdminException msg) {
		return new ResponseEntity<String>("Admin Doesn't Exist,Please Try Again.", HttpStatus.CONFLICT);
	}
	

	@ExceptionHandler(value=JobApplicationNotFoundException.class)
	public ResponseEntity<String> jobApplicationNotFoundException(JobApplicationNotFoundException msg){
		return new ResponseEntity<>("The entered job application id doesnt exist",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = JobApplicationAlreadyExistException.class)
	public ResponseEntity<String> jobApplicationAlreadyExistException(JobApplicationAlreadyExistException msg) {
		return new ResponseEntity<>("JobApplication Already Exist,Please Try Again.", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = InvalidJobApplicationException.class)
	public ResponseEntity<String> invalidJobApplicationException(InvalidJobApplicationException msg) {
		return new ResponseEntity<String>("Job Application Doesn't Exist,Please Try Again.", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = InvalidJobException.class)
	public ResponseEntity<String> invalidJobException(InvalidJobException msg) {
		return new ResponseEntity<String>("Job Doesn't Exist,Please Try Again.", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = JobAlreadyExistException.class)
	public ResponseEntity<String> jobAlreadyExistException(JobAlreadyExistException msg) {
		return new ResponseEntity<>("Job Already Exist,Please Try Again.", HttpStatus.CONFLICT);
	}

	
	@ExceptionHandler(value = InvalidFreelancerException.class)
	public ResponseEntity<String> invalidFreelancerException(InvalidFreelancerException msg) {
		return new ResponseEntity<String>("Freelancer Doesn't Exist,Please Try Again.", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = InvalidFeedbackException.class)
	public ResponseEntity<String> invalidFeedbackException(InvalidFeedbackException msg) {
		return new ResponseEntity<String>("Feedback Doesn't Exist,Please Try Again.", HttpStatus.CONFLICT);
	}

    @ExceptionHandler(value=InvalidSkillException.class)
    public ResponseEntity<String>InvalidSkillException(InvalidSkillException msg){
    	return new ResponseEntity<String>("Skill already exists , please try with another skill", HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value=InvalidSkillExperienceException.class)
    public ResponseEntity<String>InvalidSkillExperienceException(InvalidSkillExperienceException msg){
    	return new ResponseEntity<String>("Skill Experience doesn't exist",HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value=DuplicateSkillException.class)
    public ResponseEntity<String>DuplicateSkillException(DuplicateSkillException msg){
    	return new ResponseEntity<String>("Skill Already exist",HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(value = FreelancerAlreadyExistException.class)
	public ResponseEntity<String> freelancerAlreadyExistException(FreelancerAlreadyExistException msg) {
		return new ResponseEntity<String>("Freelancer Already Exist,Please Try Again.", HttpStatus.CONFLICT);

	}
}