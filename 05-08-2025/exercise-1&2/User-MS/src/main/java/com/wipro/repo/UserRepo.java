package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
