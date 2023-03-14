package com.shl.OnboardingProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Repository;

import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.HrAdmin;

@Repository
public interface HrAdminRepo extends JpaRepository<HrAdmin, Integer> {
	public List<HrAdmin> findAll();
	
	//@PostFilter("hasPermission(returnObject,'READ')")
	public List<HrAdmin> findByName(String name);
		
	public HrAdmin save(HrAdmin hrAdmin);
}
