package com.cg.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.jobportal.entity.Skill;
import com.cg.jobportal.entity.SkillExperience;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
