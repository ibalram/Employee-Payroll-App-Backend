package com.cg.employeepayrollapp.dto;

import javax.persistence.Id;

public class EmployeePayrollDTO {
	@Id
	private long id;
	public String name;
	public double salary;

	public EmployeePayrollDTO(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [employeeId=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
