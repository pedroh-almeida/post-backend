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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedro.post.dto.VotoDto;
import com.pedro.post.model.Voto;
import com.pedro.post.service.VotoService;

@RestController
@RequestMapping(value = "/votos")
public class VotoController {

	@Autowired
	private VotoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Voto> findById(@PathVariable Integer id) {
		Voto voto = service.findById(id);

		return ResponseEntity.ok().body(voto);
	}

	@GetMapping()
	public ResponseEntity<List<VotoDto>> findAllByText(
			@RequestParam(value = "texto", defaultValue = "0") Integer id_texto) {

		List<Voto> votos = service.findAllByText(id_texto);
		List<VotoDto> votosDto = votos.stream().map(obj -> new VotoDto(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(votosDto);
	}

	@PostMapping
	public ResponseEntity<Voto> create(@RequestParam(value = "texto", defaultValue = "0") Integer id_texto,
			@RequestBody Voto votoBody) {
		Voto voto = service.create(id_texto, votoBody);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/votos/{id}").buildAndExpand(voto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Voto> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
