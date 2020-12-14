package com.cg.employeepayrollapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.exceptions.DataMissingException;
import com.cg.employeepayrollapp.exceptions.NotFoundException;
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

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) throws DataMissingException{
		EmployeePayrollData empData = null;
		// empData = new EmployeePayrollData(employeePayrollList.size() + 1,
		// empPayrollDTO);
		if (empPayrollDTO.name == null || empPayrollDTO.salary.equals(null))
			throw new DataMissingException("Data missing");
		empData = new EmployeePayrollData(empPayrollDTO);
		employeePayrollRepository.save(empData);
		return empData;
	}

	public EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDTO empPayrollDTO) throws DataMissingException {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		if (empPayrollDTO.name == null || empPayrollDTO.salary.equals(null))
			throw new DataMissingException("Data missing");
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollRepository.save(empData);
		return empData;
	}

	public void deleteEmployeePayrollData(long empId) throws NotFoundException {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		if (empData == null)
			throw new NotFoundException("Not Found");
		employeePayrollRepository.deleteById(empData.getId());
	}
}
