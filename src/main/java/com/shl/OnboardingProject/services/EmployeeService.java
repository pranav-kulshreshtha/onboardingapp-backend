package com.shl.OnboardingProject.services;

import java.util.List;

import com.shl.OnboardingProject.dto.EmployeeDetail;
import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.Salary;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee employee);
	
	public Employee deleteEmployee(int empId);
	
	public Employee updateEmployeeDetail(int empId, EmployeeDetail employeeDetail);
	
	public Employee updateSalaryDetail(int empId, Salary salary);
	
	public Employee findByEmployeeId(int empId);
	
}
