package com.pedro.post.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.post.model.Texto;
import com.pedro.post.repository.TextoRepository;

@Service
public class TextoService {
	
	@Autowired
	private TextoRepository repository;
	
	
	public Texto findById (Integer id) {
		Optional<Texto> texto = repository.findById(id);
		
		return texto.orElse(null);
	}
}
