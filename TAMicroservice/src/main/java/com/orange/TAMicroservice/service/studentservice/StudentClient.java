package com.orange.TAMicroservice.service.studentservice;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@ConfigurationProperties(prefix = "studentservice", ignoreUnknownFields = false)
@Component
public class StudentClient {

	private final RestTemplate restTemplate;
	
	private String studentHost;
	
	public StudentClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	public void setStudentHost(String studentHost) {
        this.studentHost = studentHost;
    }
	
	
	public StudentDto getStudent(UUID studentId) {
		System.out.println("Calling Student Service");
		String uriPath="api/v1/student/"+studentId.toString();
		System.out.println("FULL PATH: "+studentHost+uriPath);
		try {
        	StudentDto studentDto= (restTemplate.getForObject(studentHost+uriPath, StudentDto.class));
        	System.out.println(studentDto.toString());
        	return studentDto;
    	}catch(Exception ex) {
    		System.out.println(ex.getMessage());
    		return null;
    	}
	}
	
}
