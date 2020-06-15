package com.ranyell.escola.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Avaliacao;
import com.ranyell.escola.domain.Curso;
import com.ranyell.escola.domain.Matricula;
import com.ranyell.escola.domain.Resultado;
import com.ranyell.escola.domain.Turma;
import com.ranyell.escola.repositories.AlunoRepository;
import com.ranyell.escola.repositories.AvaliacaoRepository;
import com.ranyell.escola.repositories.CursoRepository;
import com.ranyell.escola.repositories.MatriculaRepository;
import com.ranyell.escola.repositories.ResultadoRepository;
import com.ranyell.escola.repositories.TurmaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private ResultadoRepository resultadoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Aluno a1  = new Aluno(null, "Ranyell", "05187569899", "ranyell@gmail.com");
		Aluno a2  = new Aluno(null, "Jorge", "5887920169", "jorge@hotmail.com");
		Aluno a3  = new Aluno(null, "Ana", "89875242262", "ana@hotmail.com");
		Aluno a4  = new Aluno(null, "Lucas", "987551552024", "lucas@hotmail.com");
		Aluno a5  = new Aluno(null, "Pedro", "4857762213", "pedro@hotmail.com");
		Aluno a6  = new Aluno(null, "Julia", "98745645", "julia@hotmail.com");
		Aluno a7  = new Aluno(null, "Carla", "7899456321", "carla@hotmail.com");
		Aluno a8  = new Aluno(null, "Paulo", "821587462", "paulo@hotmail.com");
		Aluno a9  = new Aluno(null, "Paula", "0157468812", "paula@hotmail.com");
		Aluno a10 = new Aluno(null, "Vanessa", "7048532102", "vanessa@hotmail.com");
		Aluno a11 = new Aluno(null, "Jessica", "84554548", "jessica@hotmail.com");
		Aluno a12 = new Aluno(null, "Gomes", "4043587451", "gomes@hotmail.com");
		
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12));
		
		Curso c1 = new Curso(null, "Ciencia da Computação", 3000.0, 7.0);
		Curso c2 = new Curso(null, "Analise e desenvolvimento de sistemas", 1500.0, 5.0);
		
		Turma t1 = new Turma(null, new Date(), 60, c1);
		Turma t2 = new Turma(null, new Date(), 55, c1);
		
		Turma t3 = new Turma(null, new Date(), 50, c2);
		Turma t4 = new Turma(null, new Date(), 45, c2);
		
		cursoRepository.saveAll(Arrays.asList(c1, c2));
		turmaRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		
		Matricula m1 = new Matricula(a2, t2, new Date());
		Matricula m2 = new Matricula(a1, t3, new Date());
		
		matriculaRepository.saveAll(Arrays.asList(m1, m2));
		
		Avaliacao ava1 = new Avaliacao(null, new Date(), 10.0, t1);
		Avaliacao ava2 = new Avaliacao(null, new Date(), 10.0, t2);
		
		avaliacaoRepository.saveAll(Arrays.asList(ava1, ava2));
		
		Resultado r1 = new Resultado(a2, ava2, 8.2);
		Resultado r2 = new Resultado(a1, ava1, 8.7);
		
		resultadoRepository.saveAll(Arrays.asList(r1, r2));
		
	}
	
	

}
