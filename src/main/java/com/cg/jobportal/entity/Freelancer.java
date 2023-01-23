package com.cg.jobportal.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
/**************************************************************************************
 * @author       Arpita sp 
 * Description : This is the Entity class for freelancer module. 
 * Created Date: 23 January, 2023 
 * 
 *************************************************************************************/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Freelancer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "freelancer_id", updatable = false)
	private long id;

	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String password;


	

}
