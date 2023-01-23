package com.cg.jobportal.entity;

/*********************************************************************
 * @author vedavyas
 * Created Date: 23 January, 2023 
 * Description : This is the Entity class for Recruiter module.
 *********************************************************************/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="recruiter_id")
	private  long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String password;
		
}