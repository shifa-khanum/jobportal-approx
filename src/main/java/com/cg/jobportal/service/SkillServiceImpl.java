package com.cg.jobportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jobportal.entity.Skill;
import com.cg.jobportal.exceptions.InvalidSkillException;
import com.cg.jobportal.repository.SkillRepository;


@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepo;
	
	@Override
	public  Skill saveSkill(Skill skill) throws InvalidSkillException{
		if(skillRepo.existsById(skill.getId())) {
			throw new InvalidSkillException();
		}
		Skill savedSkill= skillRepo.save(skill);
		return savedSkill;
	}
	
	@Override
	public List<Skill> getAllSkills() {
        return skillRepo.findAll();
	}
	
	
	@Override
	public Optional<Skill> getSkillById(long id) throws InvalidSkillException {
		Optional<Skill> skill=skillRepo.findById(id);
		return skill;
	}
	
	@Override
	public String deleteSkill(long id) {
		skillRepo.deleteById(id);
		return "Deleted Successfully";
		
	}
	@Override
	public Skill updateSkill(Skill skill) {
		return skillRepo.save(skill);
	}
}

	
	