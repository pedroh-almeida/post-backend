package com.pedro.crudblog.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.crudblog.core.models.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
