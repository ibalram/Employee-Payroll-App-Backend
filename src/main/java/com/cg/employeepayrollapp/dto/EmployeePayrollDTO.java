package com.cg.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

@ToString
public class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name is invalid")
	public String name;

	@Min(value = 200000, message = "salary should be in between 200000-600000")
	@Max(value = 600000, message = "salary should be in between 200000-600000")
	public Double salary;
	
	@Pattern(regexp = "male|female", message = "Gender needs to be male/female")
	public String gender;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "startDate is required")
	@PastOrPresent(message = "startDate should be past or present")
	public LocalDate startDate;
	
	@NotBlank(message = "note can not be empty")
	public String note;
	
	@NotBlank(message = "profilePic is required")
	public String profilePic;
	
	@NotNull(message = "department should not be empty")
	public List<String> department;
	
}
