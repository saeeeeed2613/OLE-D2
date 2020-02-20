package com.orange.TAMicroservice.web.controller;

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

import com.orange.TAMicroservice.service.ReportService;
import com.orange.TAMicroservice.web.model.ReportDto;

@RequestMapping("api/v1")
@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	//This Post Method is not required in the assignment, but i implmented it to insert into DB.
	@PostMapping(path="/report")
	ResponseEntity<ReportDto> saveCourse(@RequestBody ReportDto reportDto){
		reportService.createReport(reportDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path="/report/generate/{studentId}")
	ResponseEntity<ReportDto> saveCourse(@PathVariable("studentId")UUID studentId){
		return new ResponseEntity<ReportDto>(reportService.talkToClientAndGenerateReport(studentId),HttpStatus.OK);
	}
	
}
