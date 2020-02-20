package com.orange.CoursesMicroservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.CoursesMicroservice.mappers.CourseMapper;
import com.orange.CoursesMicroservice.repository.CourseRepository;
import com.orange.CoursesMicroservice.web.controller.NotFoundException;
import com.orange.CoursesMicroservice.web.model.CourseDto;

@Service
public class CourseService {

	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	CourseRepository courseRepository;
	
	public CourseDto findCourse(UUID courseId) {
		try {
			return courseMapper.courseToCourseDto(courseRepository.findById(courseId).orElseThrow(NotFoundException::new));
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	public void createCourse(CourseDto courseDto) {
		//javax.validation Validates that courseName is not a blank, if it is a blank it will throw an exception.
		courseRepository.save(courseMapper.courseDtoToCourse(courseDto));
	}
}
