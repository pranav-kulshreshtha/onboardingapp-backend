package com.shl.OnboardingProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shl.OnboardingProject.dto.MyUserDetails;
import com.shl.OnboardingProject.entities.User;
import com.shl.OnboardingProject.repo.UserRepository;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }
    
    public User saveUser(User user) {
    	userRepository.save(user);
    	return user;
    }
}
