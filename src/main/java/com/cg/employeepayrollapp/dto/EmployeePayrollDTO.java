package com.cg.employeepayrollapp.dto;

import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.ToString;

@ToString
public class EmployeePayrollDTO {
	@Id
	private Long id;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name is invalid")
	public String name;

	@Min(value = 20000, message = "salary should be in between 20000-50000")
	@Max(value = 50000, message = "salary should be in between 20000-50000")
	public Double salary;
	public String gender;
	public String startDate;
	public String profilePic;
	public List<String> department;
	
}
