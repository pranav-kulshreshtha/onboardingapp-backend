package com.shl.OnboardingProject.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shl.OnboardingProject.dto.EmployeeDetail;
import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.Salary;
import com.shl.OnboardingProject.exceptions.EmployeeNotFoundException;
import com.shl.OnboardingProject.repo.EmployeeRepo;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> res = employeeRepo.findAll();
		return res;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployee(int empId) {
		Employee employeeToDelete = findByEmployeeId(empId);
		employeeRepo.delete(employeeToDelete);
		return employeeToDelete;
	}

	@Override
	public Employee updateEmployeeDetail(int empId, EmployeeDetail employeeDetail) {
		Employee empToUpdate = findByEmployeeId(empId);
		empToUpdate.setPhone(employeeDetail.getPhone());
		empToUpdate.setAddress(empToUpdate.getAddress());
		employeeRepo.save(empToUpdate);
		return empToUpdate;
	}

	@Override
	public Employee updateSalaryDetail(int empId, Salary salary) {
		Employee empToUpdate = findByEmployeeId(empId);
		Salary salaryToUpdate = empToUpdate.getSalary();
		salaryToUpdate.setBasic(salary.getBasic());
		salaryToUpdate.setTa(salary.getTa());
		salaryToUpdate.setDa(salary.getDa());
		salaryToUpdate.setHra(salary.getHra());
		employeeRepo.save(empToUpdate);
		return empToUpdate;
	}

	@Override
	public Employee findByEmployeeId(int empId) {
		return employeeRepo.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id = "+empId+" not found!"));
	}

}
