package com.pedro.post.dto;

import java.io.Serializable;

import com.pedro.post.model.Voto;

public class VotoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String status;
	private String comentario;

	public VotoDto() {
		super();
	}

	public VotoDto(Voto voto) {
		super();
		this.id = voto.getId();
		this.status = voto.getStatus();
		this.comentario = voto.getComentario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
