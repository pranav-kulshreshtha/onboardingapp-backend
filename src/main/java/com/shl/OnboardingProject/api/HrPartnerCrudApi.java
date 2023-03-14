package com.shl.OnboardingProject.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shl.OnboardingProject.entities.HrPartner;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.services.HrPartnerService;
import com.shl.OnboardingProject.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HrPartnerCrudApi {
	
	final private HrPartnerService hrPartnerService;
	final private UserService userService;
	final private Logger logger = LogManager.getLogger(EmployeeCrudApi.class);
	
	@PostMapping(path="/hr-partners/create")
	public ResponseEntity<HrPartner> addHrPartner(@RequestBody HrPartner hrPartner){
		logger.info("Adding new HR Partner data");
		hrPartnerService.saveHrPartner(hrPartner);
		logger.info("Successfully added new HR Partner data!");
		logger.info("Adding new user");
		userService.saveUser(
				new User(hrPartner.getName(),"pass","ROLE_HR_PARTNER"));
		logger.info("Successfully added new user!");
		return ResponseEntity.status(HttpStatus.CREATED).body(hrPartner);
	}
}
