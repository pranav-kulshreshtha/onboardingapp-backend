package com.shl.OnboardingProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.HrAdmin;
import com.shl.OnboardingProject.entities.HrPartner;

@Repository
public interface HrPartnerRepo extends JpaRepository<HrPartner, Integer> {
	public List<HrPartner> findAll();

	//@PostFilter("hasPermission(returnObject,'READ')")
	public List<HrPartner> findByName(String name);
		
	public HrPartner save(HrPartner hrPartner);
}
