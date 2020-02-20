package com.orange.TAMicroservice.web.model;

import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.Null;


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
public class ReportDto {


	@Null
	private UUID reportId;
	
	private float cumulativeGpa;
	
	private float semGpa;
	
	private String studentId;
	
	Set<EnrolledCourseDto> enrolledInCourses;
}
