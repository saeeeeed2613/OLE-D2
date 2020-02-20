package com.orange.StudentMicroservice.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EnrolledCourseDto {

	@Null
	private UUID enrollId;
	
	@NotBlank
	private String enrolledCourseId;
	
	@NotBlank
	private String courseName;
	
	@NotBlank
	@Pattern(regexp = "[A-D]?|W")
	private String achievedGrade;
}
