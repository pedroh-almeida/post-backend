package com.pedro.post.controller.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedro.post.service.exception.ObjetoNaoEncontrado;
import com.pedro.post.service.exception.ValidacaoError;
import com.pedro.post.service.exception.ViolacaoDeIntegridade;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontrado e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ViolacaoDeIntegridade.class)
	public ResponseEntity<StandardError> violacaoDeIntegridade(ViolacaoDeIntegridade e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validacaoDeErrors(MethodArgumentNotValidException e, ServletRequest request) {
		ValidacaoError error = new ValidacaoError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos.");
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addErrors(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
