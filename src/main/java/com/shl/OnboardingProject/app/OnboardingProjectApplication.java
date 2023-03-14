package com.shl.OnboardingProject.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shl.OnboardingProject.entities.Employee;
import com.shl.OnboardingProject.entities.Salary;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.services.EmployeeService;
import com.shl.OnboardingProject.services.MyUserDetailsService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shl.OnboardingProject","com.shl.OnboardingProject.filters"})
@EnableJpaRepositories("com.shl.OnboardingProject.repo")
@EntityScan({"com.shl.OnboardingProject.entities","com.shl.OnboardingProject.acl"})
public class OnboardingProjectApplication {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(OnboardingProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner getRunner() {
		return (String... args2) -> {
			employeeService.saveEmployee(new Employee("Harsh", "9999999999", "abc xyz def", new Salary(10000,2000,1000,1000)));
			employeeService.saveEmployee(new Employee("Garvit", "8888888888", "xyz def pqr", new Salary(12000,1000,5000,2000)));
			myUserDetailsService.saveUser(new User("Harsh", "pass", "ROLE_EMPLOYEE"));
			myUserDetailsService.saveUser(new User("Garvit", "pass", "ROLE_EMPLOYEE"));
		};
	}
}
