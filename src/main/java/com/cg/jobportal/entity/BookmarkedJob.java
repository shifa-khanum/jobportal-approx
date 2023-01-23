package com.cg.jobportal.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
/**************************************************************************************
 * @author       Vedavyas 
 * Description : This is the Entity class for Bookmarked Job module. 
 * Created Date: 23 January, 2023 
 * 
 *************************************************************************************/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkedJob {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookmarked_id")
	private Long id;


	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_freelancer_id")
	private Freelancer freelancer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_jobs_id")
	private Job job;

	
	
	
}