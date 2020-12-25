package com.cg.employeepayrollapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

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

	@Column(name = "salary")
	private double salary;

	private String gender;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@Column(name = "start_date")
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name="employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;
	

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.profilePic = empPayrollDTO.profilePic;
		this.department = empPayrollDTO.department;

	}
}
