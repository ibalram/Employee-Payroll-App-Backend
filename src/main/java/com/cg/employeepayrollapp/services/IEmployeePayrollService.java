package com.cg.employeepayrollapp.services;

import java.util.List;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getAllEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(long empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(long empId);
}
