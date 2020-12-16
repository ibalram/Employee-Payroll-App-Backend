package com.cg.employeepayrollapp.services;

import java.util.List;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getAllEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(Long empId);
	
	List<EmployeePayrollData> getEmployeesByDepartment(String department);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(Long empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(Long empId);
}
