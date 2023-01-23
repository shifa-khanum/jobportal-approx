package com.cg.jobportal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.jobportal.entity.SkillExperience;
import com.cg.jobportal.exceptions.InvalidSkillExperienceException;
import com.cg.jobportal.service.SkillExperienceService;

/**********************************************************************************
 * @author sangeetha
 * Created Date: 23 January, 2023 
 * Description: This class is the controller for the SkillExperience module
 **********************************************************************************/
@RestController
public class SkillExperienceController {
	
	@Autowired
	private SkillExperienceService skillExServ;

	/******************************************************************************
	 * @param skillexperience
	 * @return: Response Entity of object type 
	 * @throws InvalidSkillExperienceException
	 * @postmapping: Post mapping requests a body from the user which is then
	 *               persisted onto the database.
	 *****************************************************************************/
	@PostMapping("/addExperience")
	public ResponseEntity<SkillExperience> addSkillExperience(@RequestBody SkillExperience skillexperience) throws InvalidSkillExperienceException {
		
			SkillExperience exp=skillExServ.addSkill(skillexperience);
			return new ResponseEntity<SkillExperience>(exp, HttpStatus.OK);
	}

	/********************************************************************************
	 * @param id
	 * @return: Response Entity of object type 
	 * @throws InvalidSkillExperienceException
	 * @GetMapping: Get mapping expects a PathVariable to be passed which is then
	 *              used to return the entity object that is fetched from the
	 *              database.
	 *********************************************************************************/
	@GetMapping("/getExperience/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id)throws InvalidSkillExperienceException {
	
			return new ResponseEntity<>(skillExServ.getById(id), HttpStatus.OK);
	}	
	
	
}
