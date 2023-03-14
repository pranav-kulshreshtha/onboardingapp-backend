package com.shl.OnboardingProject.services;

import java.util.List;
import com.shl.OnboardingProject.entities.SuperAdmin;

public interface SuperAdminService {
	public List<SuperAdmin> getAllSuperAdmins();
	
	public SuperAdmin saveSuperAdmin(SuperAdmin superAdmin);
				
	public SuperAdmin findBySuperAdminId(int superAdminId);
}
