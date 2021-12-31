package com.pedro.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
