package com.pedro.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.post.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {

}
