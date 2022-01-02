package com.pedro.post.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.post.model.Voto;
import com.pedro.post.repository.VotoRepository;
import com.pedro.post.service.exception.ObjetoNaoEncontrado;

@Service
public class VotoService {

	@Autowired
	private VotoRepository repository;

	public Voto findById(Integer id) {
		Optional<Voto> voto = repository.findById(id);

		return voto.orElseThrow(
				() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID: " + id + ", TIPO: " + Voto.class.getName()));
	}
}
