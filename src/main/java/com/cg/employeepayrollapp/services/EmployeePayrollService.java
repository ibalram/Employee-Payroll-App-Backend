package com.cg.employeepayrollapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.exceptions.EmployeePayrollException;
import com.cg.employeepayrollapp.model.EmployeePayrollData;
import com.cg.employeepayrollapp.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	public List<EmployeePayrollData> getAllEmployeePayrollData() {
		return employeePayrollRepository.findAll().stream().collect(Collectors.toList());
	}

	public EmployeePayrollData getEmployeePayrollDataById(Long empId) {
		EmployeePayrollData empPayrollData = employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Not Found"));
		return empPayrollData;
	}
	
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeePayrollRepository.findEmployeeByDepartment(department);
	}

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData = new EmployeePayrollData(empPayrollDTO);
		employeePayrollRepository.save(empData);
		return empData;
	}

	public EmployeePayrollData updateEmployeePayrollData(Long empId, EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		empData.setGender(empPayrollDTO.gender);
		empData.setStartDate(empPayrollDTO.startDate);
		empData.setNote(empPayrollDTO.note);
		empData.setProfilePic(empPayrollDTO.profilePic);
		empData.setDepartments(empPayrollDTO.department);
		employeePayrollRepository.save(empData);
		return empData;
	}

	public void deleteEmployeePayrollData(Long empId){
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeePayrollRepository.deleteById(empData.getId());
	}
}
