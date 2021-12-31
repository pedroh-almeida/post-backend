package com.pedro.post;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.post.model.Texto;
import com.pedro.post.model.Voto;
import com.pedro.post.repository.TextoRepository;
import com.pedro.post.repository.VotoRepository;

@SpringBootApplication
public class PostApplication implements CommandLineRunner {

	@Autowired
	private TextoRepository textoRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Texto texto1 = new Texto(null, "Lorem", "Lorem Ipsum e abobrinhas");
		Voto voto1 = new Voto(null, "não gostei", "o texto não é tão informativo quanto deveria ser", texto1);
		
		texto1.getVotos().addAll(Arrays.asList(voto1));
		
		this.textoRepository.saveAll(Arrays.asList(texto1));
		this.votoRepository.saveAll(Arrays.asList(voto1));
		
	}

}
