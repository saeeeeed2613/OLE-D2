package com.orange.TAMicroservice.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class EnrolledCourse {

	

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID enrollId;
	
	
	private String enrolledCourseId;
	
	private String courseName;
	

	@Pattern(regexp = "[A-D]?|W")
	private String achievedGrade;
}
