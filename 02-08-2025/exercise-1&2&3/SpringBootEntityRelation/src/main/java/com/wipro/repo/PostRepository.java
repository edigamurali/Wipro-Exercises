package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
