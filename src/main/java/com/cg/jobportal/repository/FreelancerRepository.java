package com.cg.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.jobportal.entity.Freelancer;


@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
	
	Freelancer findByUserName(@Param("name")String userName);

	


	
}
