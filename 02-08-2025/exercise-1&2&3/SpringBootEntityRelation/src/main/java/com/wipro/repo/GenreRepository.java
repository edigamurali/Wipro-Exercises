package com.wipro.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
