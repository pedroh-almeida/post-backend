package com.pedro.post.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<VotoDto>> findAllByText(@RequestParam(value = "texto", defaultValue = "0") Integer id_texto) {
		
		List<Voto> votos = service.findAllByText(id_texto);
		List<VotoDto> votosDto = votos.stream().map(obj -> new VotoDto(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(votosDto);
	}
}
