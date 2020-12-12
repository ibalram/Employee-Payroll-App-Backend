package com.cg.employeepayrollapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employee_payroll_data")
public class EmployeePayrollData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "basic_pay")
	private double salary;

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		// this.id = empId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
