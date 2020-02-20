package com.orange.StudentMicroservice.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PrevGPA {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID prevGpaId;
	

	@Min(1)
	@Max(8)
	private int semNumber;
	

	@Min(0)
	@Max(4)
	private float cummulativeGpa;

}
