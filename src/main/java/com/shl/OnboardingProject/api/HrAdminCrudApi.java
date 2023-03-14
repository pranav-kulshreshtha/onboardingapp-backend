package com.shl.OnboardingProject.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shl.OnboardingProject.entities.HrAdmin;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.services.HrAdminService;
import com.shl.OnboardingProject.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HrAdminCrudApi {
	
	final private HrAdminService hrAdminService;
	final private UserService userService;
	final private Logger logger = LogManager.getLogger(EmployeeCrudApi.class);

	@PostMapping(path="/hr-admins/create")
	public ResponseEntity<HrAdmin> addHrAdmin(@RequestBody HrAdmin hrAdmin){
		logger.info("Adding new HR Admin data");
		hrAdminService.saveHrAdmin(hrAdmin);
		logger.info("Successfully added new HR Admin data!");
		logger.info("Adding new user");
		userService.saveUser(
				new User(hrAdmin.getName(),"pass","ROLE_HR_ADMIN"));
		logger.info("Successfully added new user!");
		return ResponseEntity.status(HttpStatus.CREATED).body(hrAdmin);
	}
}
