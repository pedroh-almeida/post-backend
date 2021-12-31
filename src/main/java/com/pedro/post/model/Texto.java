package com.pedro.post.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Texto {

	private Integer id;
	private String titulo;
	private String conteudo;

	private List<Voto> votos = new ArrayList<>();

	public Texto() {
		super();
	}

	public Texto(Integer id, String titulo, String conteudo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
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

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Texto other = (Texto) obj;
		return Objects.equals(id, other.id);
	}

}
