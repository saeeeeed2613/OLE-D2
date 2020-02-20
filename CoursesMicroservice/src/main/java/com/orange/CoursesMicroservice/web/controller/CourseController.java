package com.orange.CoursesMicroservice.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.CoursesMicroservice.service.CourseService;
import com.orange.CoursesMicroservice.web.model.CourseDto;



@RequestMapping("api/v1")
@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping(path = "/course/{courseId}")
	ResponseEntity<CourseDto> getCourse(@PathVariable("courseId")UUID courseId){
		CourseDto retrievedCourseDto=courseService.findCourse(courseId);
		if(retrievedCourseDto==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<CourseDto>(retrievedCourseDto,HttpStatus.OK);
	}
	
	//This Post Method is not required in the assignment, but i implmented it to insert into DB.
	@PostMapping(path="/course")
	ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto){
		courseService.createCourse(courseDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
