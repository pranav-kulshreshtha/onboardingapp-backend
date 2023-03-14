package com.shl.OnboardingProject.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shl.OnboardingProject.entities.SuperAdmin;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.services.SuperAdminService;
import com.shl.OnboardingProject.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SuperAdminCrudApi {
	
	final private SuperAdminService superAdminService;
	final private UserService userService;
	final private Logger logger = LogManager.getLogger(EmployeeCrudApi.class);
	
	@PostMapping(path="/super-admins/create")
	public ResponseEntity<SuperAdmin> addHrPartner(@RequestBody SuperAdmin superAdmin){
		logger.info("Adding new SuperAdmin data");
		superAdminService.saveSuperAdmin(superAdmin);
		logger.info("Successfully added new SuperAdmin data!");
		logger.info("Adding new user");
		userService.saveUser(
				new User(superAdmin.getName(),"pass","ROLE_SUPER_ADMIN"));
		logger.info("Successfully added new user!");
		return ResponseEntity.status(HttpStatus.CREATED).body(superAdmin);
	}
}
