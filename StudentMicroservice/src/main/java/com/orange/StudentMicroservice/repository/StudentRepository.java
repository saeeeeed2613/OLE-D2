package com.orange.StudentMicroservice.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.orange.StudentMicroservice.domain.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student,UUID> {

}
