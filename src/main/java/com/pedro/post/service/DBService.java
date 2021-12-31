package com.pedro.post.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.post.model.Texto;
import com.pedro.post.model.Voto;
import com.pedro.post.repository.TextoRepository;
import com.pedro.post.repository.VotoRepository;

@Service
public class DBService {

	@Autowired
	private TextoRepository textoRepository;

	@Autowired
	private VotoRepository votoRepository;

	public void instanciaBaseDeDados() {
		Texto texto1 = new Texto(null, "Texto 1", "Aqui terei o voto 1.");
		Texto texto2 = new Texto(null, "Texto 2", "Aqui terei os votos 2 e 4.");
		Texto texto3 = new Texto(null, "Texto 3", "Aqui terei os votos 3 e 5.");

		Voto voto1 = new Voto(null, "Positivo 1", "Comentário do voto 1 relacionado ao texto 1.", texto1);
		Voto voto2 = new Voto(null, "Negativo 2", "Comentário do voto 2 relacionado ao texto 2.", texto2);
		Voto voto3 = new Voto(null, "Negativo 3", "Comentário do voto 3 relacionado ao texto 3.", texto3);
		Voto voto4 = new Voto(null, "Positivo 4", "Comentário do voto 4 relacionado ao texto 2.", texto2);
		Voto voto5 = new Voto(null, "Negativo 5", "Comentário do voto 5 relacionado ao texto 3", texto3);

		texto1.getVotos().addAll(Arrays.asList(voto1));
		texto2.getVotos().addAll(Arrays.asList(voto2, voto4));
		texto3.getVotos().addAll(Arrays.asList(voto3, voto5));

		this.textoRepository.saveAll(Arrays.asList(texto1, texto2, texto3));
		this.votoRepository.saveAll(Arrays.asList(voto1, voto2, voto3, voto4, voto5));
	}
}
