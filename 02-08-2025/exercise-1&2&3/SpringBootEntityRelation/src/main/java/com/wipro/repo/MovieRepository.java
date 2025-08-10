package com.wipro.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

