package com.shl.OnboardingProject.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.repo.UserRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public User findByUserId(int uid) {
		return userRepository.getById(uid);
	}

}
