package com.pedro.post.service.exception;

import java.io.Serializable;

public class MessageDoCampo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;

	public MessageDoCampo() {
		super();
	}

	public MessageDoCampo(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
