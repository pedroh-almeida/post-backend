package com.pedro.post.service.exception;

public class ObjetoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontrado(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNaoEncontrado(String message) {
		super(message);
	}

}
