package com.pedro.post.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedro.post.dto.TextoDto;
import com.pedro.post.model.Texto;
import com.pedro.post.service.TextoService;

@RestController
@RequestMapping(value = "/textos")
public class TextoController {

	@Autowired
	private TextoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Texto> findById(@PathVariable Integer id) {
		Texto texto = service.findById(id);
		
		return ResponseEntity.ok().body(texto);
	}
	
	@GetMapping
	public ResponseEntity<List<TextoDto>> findAll() {
		List<Texto> textos = service.findAll();
		List<TextoDto> textosDto = textos.stream().map(texto -> new TextoDto(texto)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(textosDto);
	}
	
	@PostMapping
	public ResponseEntity<Texto> create (@RequestBody Texto texto) {
		texto = service.create(texto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(texto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(texto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TextoDto> update(@PathVariable Integer id, @RequestBody TextoDto textoDto) {
		Texto texto = service.update(id, textoDto);
		return ResponseEntity.ok().body(new TextoDto(texto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
