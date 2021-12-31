package com.pedro.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.post.model.Texto;

@Repository
public interface TextoRepository extends JpaRepository<Texto, Integer>{

}
