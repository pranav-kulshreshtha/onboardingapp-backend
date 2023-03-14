package com.shl.OnboardingProject.services;

import java.util.List;
import com.shl.OnboardingProject.entities.HrAdmin;

public interface HrAdminService {
	public List<HrAdmin> getAllHrAdmins();
	
	public HrAdmin saveHrAdmin(HrAdmin HrAdmin);
				
	public HrAdmin findByHrAdminId(int hrAdminId);
}
