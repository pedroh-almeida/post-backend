package com.pedro.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.post.model.Texto;
import com.pedro.post.model.Voto;
import com.pedro.post.repository.VotoRepository;
import com.pedro.post.service.exception.ObjetoNaoEncontrado;

@Service
public class VotoService {

	@Autowired
	private VotoRepository repository;
	
	@Autowired
	private TextoService textoService;

	public Voto findById(Integer id) {
		Optional<Voto> voto = repository.findById(id);

		return voto.orElseThrow(
				() -> new ObjetoNaoEncontrado("Objeto não encontrado! ID: " + id + ", TIPO: " + Voto.class.getName()));
	}

	public List<Voto> findAllByText(Integer id_texto) {
		textoService.findById(id_texto);
		
		return repository.findAllByText(id_texto);
	}

	public Voto create(Integer id_texto, Voto votoBody) {
		votoBody.setId(null);
		Texto texto = textoService.findById(id_texto);
		votoBody.setTexto(texto);
		
		return repository.save(votoBody);
	}

	public void delete(Integer id) {
		Voto voto = this.findById(id);
		
		repository.delete(voto);
	}
	
	
}
