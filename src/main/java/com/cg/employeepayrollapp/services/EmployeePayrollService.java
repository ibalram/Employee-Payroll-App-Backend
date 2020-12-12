package com.cg.employeepayrollapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.model.EmployeePayrollData;
import com.cg.employeepayrollapp.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	// private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	// public List<EmployeePayrollData> getEmployeePayrollData() {
	// return employeePayrollList;
	// }

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	public List<EmployeePayrollData> getAllEmployeePayrollData() {
		return employeePayrollRepository.findAll().stream().collect(Collectors.toList());
	}

	public EmployeePayrollData getEmployeePayrollDataById(long empId) {
		EmployeePayrollData empPayrollData = employeePayrollRepository.findById(empId).get();
		return empPayrollData;
	}

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		// empData = new EmployeePayrollData(employeePayrollList.size() + 1,
		// empPayrollDTO);
		empData = new EmployeePayrollData(empPayrollDTO);
		employeePayrollRepository.save(empData);
		return empData;
	}

	public EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollRepository.save(empData);
		return empData;
	}

	public void deleteEmployeePayrollData(long empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeePayrollRepository.deleteById(empData.getId());
	}
}
