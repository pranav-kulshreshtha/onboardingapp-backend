package com.shl.OnboardingProject.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shl.OnboardingProject.dto.AuthenticationRequest;
import com.shl.OnboardingProject.dto.AuthenticationResponse;
import com.shl.OnboardingProject.dto.EmployeeDetail;
import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.services.EmployeeService;
import com.shl.OnboardingProject.services.UserService;
import com.shl.OnboardingProject.util.JwtUtil;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeCrudApi {
	
	final private EmployeeService employeeService;
	final private AuthenticationManager authenticationManager;
	final private UserDetailsService userDetailsService;
	final private JwtUtil jwtTokenUtil;
	final private UserService userService;
	final private Logger logger = LogManager.getLogger(EmployeeCrudApi.class);
	
	@GetMapping("/")
	public ResponseEntity<String> getWelcomePage() {
		logger.trace("Calling root api method");
		logger.info("Loading homepage");
		return ResponseEntity.ok().body("<h1>Welcome</h1>");
	}
	
	@GetMapping(path="employees")
	//@PostFilter("hasPermission(filterObject,'READ')")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		logger.info("Loading employee list");
		logger.warn("Only specific roles are allowed to access");
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}
	
	@GetMapping(path="employees/{id}")
	public ResponseEntity<Employee> getAnEmployee(@PathVariable int id){
		logger.info("Loading employee data as requested");
		return ResponseEntity.ok().body(employeeService.findByEmployeeId(id));
	}
	
	@PostMapping(path="employees/create")
	//@PreAuthorize("hasRole('ROLE_HR_ADMIN')")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		logger.info("Saving employee");
		employeeService.saveEmployee(employee);
		logger.info("Employee saved successfully!");
		logger.info("Adding employee to users");
		userService.saveUser(
				new User(employee.getName(),"pass","ROLE_EMPLOYEE"));
		logger.info("User added successfully!");
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	@GetMapping(path="/authenticate")
	public ResponseEntity<?> helloworld(){
		return ResponseEntity.ok().body("<h1>Authentication get version</h1>");
	}
	
	@PostMapping(path="/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody 
			AuthenticationRequest authenticationRequest) throws Exception{
		try {
			logger.info("Authenticating user");
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authenticationRequest.getUsername(), 
						authenticationRequest.getPassword())
			);
		}
		catch(BadCredentialsException e) {
			logger.error("Invalid username or password!");
			return ResponseEntity.ok("Incorrect username or password");
			//throw new Exception("Incorrect username or password",e);
		}
		logger.info("User authenticated successfully!");
		logger.info("Fetching user details");
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		logger.info("Generating token");
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		logger.info("Token generated successfully!");
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@DeleteMapping(path = "employees/{id}")
	public ResponseEntity<Void> deleteAnEmployee(@PathVariable int id){
		logger.info("Deleting employee");
		employeeService.deleteEmployee(id);
		logger.info("Deleted employee successfully");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(path = "employees/{id}")
	public ResponseEntity<Employee> updateAnEmployee(@PathVariable int id,
			@RequestBody EmployeeDetail employeeDetail){
		logger.info("Updating employee");
		Employee updatedEmployee=  employeeService.updateEmployeeDetail(id, employeeDetail);
		logger.info("Updated employee successfully!");
		return ResponseEntity.ok().body(updatedEmployee);
	}
}
