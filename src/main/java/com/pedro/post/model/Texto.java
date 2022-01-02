package com.pedro.post.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
public class Texto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Título é obrigatório.")
	@Length(min = 2, max = 50, message = "Título deve ter entre 2 e 50 caracteres.")
	private String titulo;
	
	@NotEmpty(message = "Conteúdo é obrigatório.")
	@Length(min = 20, max = 5000, message = "Conteúdo deve ter no mínimo 20.")
	private String conteudo;

	
	@OneToMany(mappedBy = "texto")
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
