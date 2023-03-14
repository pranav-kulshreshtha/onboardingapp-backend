package com.shl.OnboardingProject.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shl.OnboardingProject.entities.HrAdmin;
import com.shl.OnboardingProject.exceptions.EmployeeNotFoundException;
import com.shl.OnboardingProject.repo.HrAdminRepo;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class HrAdminServiceImpl implements HrAdminService {

	private final HrAdminRepo hrAdminRepo;

	@Override
	public List<HrAdmin> getAllHrAdmins() {
		List<HrAdmin> res = hrAdminRepo.findAll();
		return res;
	}

	@Override
	public HrAdmin saveHrAdmin(HrAdmin hrAdmin) {
		hrAdminRepo.save(hrAdmin);
		return hrAdmin;	
	}

	@Override
	public HrAdmin findByHrAdminId(int hrAdminId) {
		return hrAdminRepo.findById(hrAdminId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id not found!"));
	}

}
