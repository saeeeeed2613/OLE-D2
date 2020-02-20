package com.orange.TAMicroservice.domain;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {


	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID reportId;
	
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	
	
	private float cumulativeGpa;
	
	private float semGpa;
	
	private String studentId;
	

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="reportId")
	Set<EnrolledCourse> enrolledInCourses;
}
