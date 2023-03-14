package com.shl.OnboardingProject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shl.OnboardingProject.entities.HrPartner;
import com.shl.OnboardingProject.exceptions.EmployeeNotFoundException;
import com.shl.OnboardingProject.repo.HrPartnerRepo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class HrPartnerServiceImpl implements HrPartnerService {
	private final HrPartnerRepo hrPartnerRepo;

	@Override
	public List<HrPartner> getAllHrPartners() {
		List<HrPartner> res = hrPartnerRepo.findAll();
		return res;
	}

	@Override
	public HrPartner saveHrPartner(HrPartner hrPartner) {
		hrPartnerRepo.save(hrPartner);
		return hrPartner;	
	}

	@Override
	public HrPartner findByHrPartnerId(int hrPartnerId) {
		return hrPartnerRepo.findById(hrPartnerId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id not found!"));
	}


}
