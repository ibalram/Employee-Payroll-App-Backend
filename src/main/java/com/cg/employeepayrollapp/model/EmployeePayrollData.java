package com.cg.employeepayrollapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_payroll_data")
public class EmployeePayrollData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "basic_pay")
	private double salary;

	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;
	

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = LocalDate.parse(empPayrollDTO.startDate);
		this.profilePic = empPayrollDTO.profilePic;
		this.departments = empPayrollDTO.department;

	}
}
