package com.pedro.post.dto;

import java.io.Serializable;

import com.pedro.post.model.Texto;

public class TextoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
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
