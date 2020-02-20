package com.orange.TAMicroservice.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.TAMicroservice.mapper.ReportMapper;
import com.orange.TAMicroservice.repository.ReportRepository;
import com.orange.TAMicroservice.service.studentservice.PrevGPADto;
import com.orange.TAMicroservice.service.studentservice.StudentClient;
import com.orange.TAMicroservice.service.studentservice.StudentDto;
import com.orange.TAMicroservice.web.model.EnrolledCourseDto;
import com.orange.TAMicroservice.web.model.GPAGetter;
import com.orange.TAMicroservice.web.model.ReportDto;


@Service
public class ReportService {

	@Autowired
	ReportMapper reportMapper;
	
	@Autowired
	ReportRepository reportRepository;
	
	@Autowired
	StudentClient studentClient;
	
	public void createReport(ReportDto reportDto) {
		try {                                 
			reportRepository.save(reportMapper.reportDtoToReport(reportDto));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ReportDto talkToClientAndGenerateReport(UUID studentId) {
		StudentDto studentDto=studentClient.getStudent(studentId);
		return generateReport(studentDto,studentId);
		
	}
	
	ReportDto generateReport(StudentDto studentDto,UUID studentId){
		return ReportDto.builder()
				.enrolledInCourses(studentDto.getEnrolledCourse())
				.cumulativeGpa(calcCumGPA(studentDto.getPreviousGPA()))
				.semGpa(calSemGPA(studentDto.getEnrolledCourse()))
				.studentId(studentId.toString())
				.build();
		
		
	}
	
	float calcCumGPA(Set<PrevGPADto> prevGpa)
	{
		float sum=0F;
		for(PrevGPADto semesterInfo:prevGpa) {
			sum+=semesterInfo.getCummulativeGpa();
		}
		return (sum/prevGpa.size());
	}
	
	float calSemGPA(Set<EnrolledCourseDto> enrolledCourseDtos) {
		float sum=0F;
		for(EnrolledCourseDto enrolledCourseResult:enrolledCourseDtos)
		{
			sum+=GPAGetter.getEquvPoints(enrolledCourseResult.getAchievedGrade());
		}
		return (sum/enrolledCourseDtos.size());
	}
}
