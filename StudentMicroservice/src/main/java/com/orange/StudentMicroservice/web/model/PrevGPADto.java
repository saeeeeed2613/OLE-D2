package com.orange.StudentMicroservice.web.model;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PrevGPADto {

	@Null
	private UUID prevGpaId;
	
	@NotBlank
	private int semNumber;
	
	@NotBlank
	private float cummulativeGpa;
}
