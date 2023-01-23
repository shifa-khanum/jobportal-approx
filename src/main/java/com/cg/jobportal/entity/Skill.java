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

/****************************************************************
 * 
 * @author sangeetha
 * Created Date: 23 January, 2023 
 * Description : This is the Entity class for Skill module.
 *
 ****************************************************************/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skill_id")
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_freelancer_id")
	private Freelancer freelancer;


	
	}

