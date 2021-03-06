package com.pedro.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedro.post.dto.TextoDto;
import com.pedro.post.model.Texto;
import com.pedro.post.repository.TextoRepository;
import com.pedro.post.service.exception.ObjetoNaoEncontrado;
import com.pedro.post.service.exception.ViolacaoDeIntegridade;

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

	public Texto create(Texto texto) {
		texto.setId(null);
		
		return repository.save(texto);
	}

	public Texto update(Integer id, TextoDto textoDto) {
		Texto texto = findById(id);
		texto.setConteudo(textoDto.getConteudo());
		texto.setTitulo(textoDto.getTitulo());
		
		return repository.save(texto);
	}

	public void delete(Integer id) {
		repository.findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ViolacaoDeIntegridade("Texto não pode ser deletado! Existem votos associados.");
		}
	}
}
