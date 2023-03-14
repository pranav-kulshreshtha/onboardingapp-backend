package com.shl.OnboardingProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shl.OnboardingProject.entities.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUserName(String userName);
}
