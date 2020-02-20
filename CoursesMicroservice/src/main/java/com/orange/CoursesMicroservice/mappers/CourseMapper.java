package com.orange.CoursesMicroservice.mappers;

import org.mapstruct.Mapper;

import com.orange.CoursesMicroservice.domain.Course;
import com.orange.CoursesMicroservice.web.model.CourseDto;



@Mapper(uses= {DateMapper.class})
public interface CourseMapper {

	CourseDto courseToCourseDto(Course course);
	Course courseDtoToCourse(CourseDto courseDto);
}
