package com.cg.jobportal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.jobportal.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

	Job findByJobTitle(@Param("Title")String jobTitle);

}
