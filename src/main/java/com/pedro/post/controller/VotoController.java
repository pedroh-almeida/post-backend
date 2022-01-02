package com.pedro.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
