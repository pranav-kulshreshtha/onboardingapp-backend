package com.shl.OnboardingProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.SuperAdmin;

@Repository
public interface SuperAdminRepo extends JpaRepository<SuperAdmin, Integer> {
	public List<SuperAdmin> findAll();

	//@PostFilter("hasPermission(returnObject,'READ')")
	public List<SuperAdmin> findByName(String name);
		
	public SuperAdmin save(SuperAdmin superAdmin);
}
