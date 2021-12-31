package com.pedro.post.controller.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedro.post.service.exception.ObjetoNaoEncontrado;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontrado e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
