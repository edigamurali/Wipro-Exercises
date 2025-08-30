package com.wipro.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.user.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
