package com.orange.TAMicroservice.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.orange.TAMicroservice.domain.Report;

public interface ReportRepository extends PagingAndSortingRepository<Report,UUID> {

}
