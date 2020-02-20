package com.orange.StudentMicroservice.domain;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID studentId;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	
	
	private int year;
	
	private String Season;
	

	@Min(1)
	@Max(8)
	private int semesterNum;
	

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="studentId")
    private Set<PrevGPA> previousGPA;
	

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="studentId")
    private Set<EnrolledCourse> enrolledCourse;
	
}
