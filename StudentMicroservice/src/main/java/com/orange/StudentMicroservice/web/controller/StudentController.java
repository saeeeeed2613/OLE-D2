package com.orange.StudentMicroservice.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.StudentMicroservice.service.StudentService;
import com.orange.StudentMicroservice.web.model.StudentDto;

@RequestMapping("api/v1")
@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping(path = "/student/{studentId}")
	ResponseEntity<StudentDto> getStudent(@PathVariable("studentId")UUID studentId){
		StudentDto retrievedStudentDto=studentService.findStudent(studentId);
		if(retrievedStudentDto==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<StudentDto>(retrievedStudentDto,HttpStatus.OK);
	}	
	
	//This Post Method is not required in the assignment, but i implmented it to insert into DB.
	@PostMapping(path="/student")
	ResponseEntity<StudentDto> saveCourse(@RequestBody StudentDto studentDto){
		studentService.createStudent(studentDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path="/student/{studentId}")
	ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId")UUID studentId,
											@RequestBody StudentDto studentDto){
		studentService.updateStudent(studentId,studentDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
