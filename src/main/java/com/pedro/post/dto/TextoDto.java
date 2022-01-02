package com.pedro.post.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.pedro.post.model.Texto;

public class TextoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Título é obrigatório.")
	@Length(min = 2, max = 50, message = "Título deve ter entre 2 e 50 caracteres.")
	private String titulo;
	
	@NotEmpty(message = "Conteúdo é obrigatório.")
	@Length(min = 20, message = "Conteúdo deve ter no mínimo 20.")
	private String conteudo;

	public TextoDto() {
		super();
	}

	public TextoDto(Texto texto) {
		super();
		this.id = texto.getId();
		this.titulo = texto.getTitulo();
		this.conteudo = texto.getConteudo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
