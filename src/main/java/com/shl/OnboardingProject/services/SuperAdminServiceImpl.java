package com.shl.OnboardingProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shl.OnboardingProject.entities.SuperAdmin;
import com.shl.OnboardingProject.entities.SuperAdmin;
import com.shl.OnboardingProject.exceptions.EmployeeNotFoundException;
import com.shl.OnboardingProject.repo.SuperAdminRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class SuperAdminServiceImpl implements SuperAdminService {

	private final SuperAdminRepo superAdminRepo;

	@Override
	public List<SuperAdmin> getAllSuperAdmins() {
		List<SuperAdmin> res = superAdminRepo.findAll();
		return res;
	}

	@Override
	public SuperAdmin saveSuperAdmin(SuperAdmin superAdmin) {
		superAdminRepo.save(superAdmin);
		return superAdmin;	
	}

	@Override
	public SuperAdmin findBySuperAdminId(int SuperAdminId) {
		return superAdminRepo.findById(SuperAdminId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id not found!"));
	}


}
