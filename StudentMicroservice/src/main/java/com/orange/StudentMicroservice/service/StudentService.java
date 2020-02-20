package com.orange.StudentMicroservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.StudentMicroservice.mapper.StudentMapper;
import com.orange.StudentMicroservice.repository.StudentRepository;
import com.orange.StudentMicroservice.web.controller.NotFoundException;
import com.orange.StudentMicroservice.web.model.StudentDto;

@Service
public class StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	StudentRepository studentRepository;
	
	public StudentDto findStudent(UUID studentId) {
		try {
			return studentMapper.studentToStudentDto(studentRepository.findById(studentId).orElseThrow(NotFoundException::new));
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void updateStudent(UUID studentId,StudentDto studentDto) {
		try {

			//Get user from DB based on studentId
			StudentDto retrievedStudent=studentMapper.studentToStudentDto(studentRepository.findById(studentId).orElseThrow(NotFoundException::new));
			/*
			retrievedStudent
							.getEnrolledCourse()(studentDto.getEnrolledCourse())
							.year(studentDto.getYear())
							.season(studentDto.getSeason())
							.semesterNum(studentDto.getSemesterNum())
							.build();
			studentRepository.save(entity)
			*/
							
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void createStudent(StudentDto studentDto) {
		try {                                 
			studentRepository.save(studentMapper.studentDtoToStudent(studentDto));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
