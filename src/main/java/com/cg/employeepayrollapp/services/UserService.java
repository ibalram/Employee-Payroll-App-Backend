package com.cg.employeepayrollapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.repository.EmployeePayrollRepository;

public class UserService {

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	public List<EmployeePayrollDTO> getAllUser() {
		return employeePayrollRepository.findAll().stream()
				.map(employeePayroll -> new EmployeePayrollDTO(employeePayroll.getName(), employeePayroll.getSalary()))
				.collect(Collectors.toList());
	}

}
