package com.shl.OnboardingProject.services;

import java.util.List;
import com.shl.OnboardingProject.entities.HrPartner;

public interface HrPartnerService {
	public List<HrPartner> getAllHrPartners();
	
	public HrPartner saveHrPartner(HrPartner hrPartner);
				
	public HrPartner findByHrPartnerId(int hrPartnerId);
}
