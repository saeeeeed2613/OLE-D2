package com.orange.TAMicroservice.service.studentservice;

import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import com.orange.TAMicroservice.web.model.EnrolledCourseDto;

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
public class StudentDto {

	@Null
	private UUID studentId;
	
	@NotBlank
	private int year;
	
	@NotBlank
	private String season;
	
	@NotBlank
	private int semesterNum;
	
	
	Set<PrevGPADto> previousGPA;
	
	Set<EnrolledCourseDto> enrolledCourse;
	
}
