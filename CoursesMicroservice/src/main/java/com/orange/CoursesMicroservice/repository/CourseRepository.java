package com.orange.CoursesMicroservice.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.orange.CoursesMicroservice.domain.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course,UUID> {

}
