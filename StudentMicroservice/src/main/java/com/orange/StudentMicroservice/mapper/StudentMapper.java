package com.orange.StudentMicroservice.mapper;

import org.mapstruct.Mapper;

import com.orange.StudentMicroservice.domain.Student;
import com.orange.StudentMicroservice.web.model.StudentDto;



@Mapper(uses= {DateMapper.class})
public interface StudentMapper {

	StudentDto studentToStudentDto(Student student);
	Student studentDtoToStudent(StudentDto studentDto);
}
