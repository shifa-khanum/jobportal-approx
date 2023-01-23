package com.cg.jobportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cg.jobportal.entity.Skill;
import com.cg.jobportal.exceptions.InvalidSkillException;

@Service
public interface SkillService {

	Skill saveSkill(Skill skill) throws InvalidSkillException;

	List<Skill> getAllSkills() ;
	
	

	String deleteSkill(long id) ;

	Skill updateSkill(Skill skill);

	Optional<Skill> getSkillById(long id) throws InvalidSkillException;

}
