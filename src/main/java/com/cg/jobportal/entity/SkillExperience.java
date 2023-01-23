package com.cg.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*************************************************************************
 * 
 * @author sangeetha
 * Created Date: 23 January, 2023 
 * Description : This is the Entity class for SkillExperience module.
 *
 *************************************************************************/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillExperience {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 private int years;
	 
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="fk_id_of_skill")
		private Skill skill;

}
