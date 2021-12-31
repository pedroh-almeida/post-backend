package com.pedro.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.post.model.Texto;
import com.pedro.post.repository.TextoRepository;
import com.pedro.post.service.exception.ObjetoNaoEncontrado;

@Service
public class TextoService {

	@Autowired
	private TextoRepository repository;

	public Texto findById(Integer id) {
		Optional<Texto> texto = repository.findById(id);

		return texto.orElseThrow(
				() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID: " + id + ". TIPO: " + Texto.class.getName()));
	}
	
	public List<Texto> findAll() {
		return repository.findAll();
	}
}
