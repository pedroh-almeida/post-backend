package com.pedro.post.service.exception;

import java.util.ArrayList;
import java.util.List;

import com.pedro.post.controller.exception.StandardError;

public class ValidacaoError extends StandardError {

	private List<MessageDoCampo> errors = new ArrayList<>();

	public ValidacaoError() {
		super();
	}

	public ValidacaoError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public List<MessageDoCampo> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new MessageDoCampo(fieldName, message));
	}

}
