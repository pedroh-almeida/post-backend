package com.pedro.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedro.post.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {

	@Query("SELECT obj FROM Voto obj WHERE obj.texto.id = :id_texto ORDER BY id")
	List<Voto> findAllByText(@Param(value = "id_texto") Integer id_texto);

}
