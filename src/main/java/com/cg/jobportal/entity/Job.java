package com.cg.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/************************************************************
 * @author sahana
 * Created Date: 23 January, 2023 
 * Description : This is the Entity class for Job module. 
 ************************************************************/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String jobTitle;
	@Column(nullable = false)
	private String jobDescription;
	@Column(nullable = false)
	private Boolean active;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_recruiter_id")
	private Recruiter recruiter;

}
