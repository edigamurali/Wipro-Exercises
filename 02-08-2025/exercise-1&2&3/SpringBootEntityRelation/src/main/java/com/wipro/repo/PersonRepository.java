package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
