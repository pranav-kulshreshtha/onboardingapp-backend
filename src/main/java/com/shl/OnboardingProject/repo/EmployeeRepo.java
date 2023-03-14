package com.shl.OnboardingProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.shl.OnboardingProject.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAll();
	
	@PostFilter("hasPermission(returnObject,'READ')")
	public List<Employee> findByName(String name);
	
	@PostAuthorize("hasPermission(returnObject,'READ')")
	public Employee findByPhone(String phone);
	
	public Employee save(Employee employee);
}
