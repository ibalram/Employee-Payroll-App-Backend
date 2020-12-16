package com.cg.employeepayrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.employeepayrollapp.model.EmployeePayrollData;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Long> {

	@Query(value = "select * from employee_payroll_data, employee_department where employee_payroll_data.id = employee_department.id and department = :department", nativeQuery = true)
	List<EmployeePayrollData> findEmployeeByDepartment(String department);

}
