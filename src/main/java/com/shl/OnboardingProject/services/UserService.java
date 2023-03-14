package com.shl.OnboardingProject.services;
import java.util.List;
import com.shl.OnboardingProject.entities.User;

public interface UserService {
	public List<User> getAllUsers();
	public User saveUser(User user);			
	public User findByUserId(int empId);
}
