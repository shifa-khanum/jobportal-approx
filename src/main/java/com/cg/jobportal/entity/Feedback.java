package com.cg.jobportal.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
/**************************************************************************************
 * @author       Mohamed kather 
 * Description : This is the Entity class for Feedback module. 
 * Created Date: 23 January, 2023 
 * 
 *************************************************************************************/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue
	long id;

	@Min(1)
	@Max(10)
	@Column(nullable = false)
	int ranges;
	
	@Length(max = 50)
	@Column(nullable = false)
	String comments;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_recruiter")
	private Recruiter recruiter;

}
