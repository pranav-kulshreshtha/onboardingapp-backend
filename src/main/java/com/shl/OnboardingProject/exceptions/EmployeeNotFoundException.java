package com.shl.OnboardingProject.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	private static final long serialVersionUid = 1L;
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
