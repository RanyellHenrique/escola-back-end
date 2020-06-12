package com.ranyell.escola.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Curso;
import com.ranyell.escola.domain.Turma;
import com.ranyell.escola.repositories.AlunoRepository;
import com.ranyell.escola.repositories.CursoRepository;
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

	@Override
	public void run(String... args) throws Exception {
		
		Aluno a1 = new Aluno(null, "Ranyell", "05187569899");
		Aluno a2 = new Aluno(null, "Jorge", "5887920169");
		
		alunoRepository.saveAll(Arrays.asList(a1, a2));
		
		Curso c1 = new Curso(null, "Ciencia da Computação", 3000.0, 7.0);
		Curso c2 = new Curso(null, "Analise e desenvolvimento de sistemas", 1500.0, 5.0);
		
		Turma t1 = new Turma(null, new Date(), 60, c1);
		Turma t2 = new Turma(null, new Date(), 55, c1);
		
		Turma t3 = new Turma(null, new Date(), 50, c2);
		Turma t4 = new Turma(null, new Date(), 45, c2);
		
		cursoRepository.saveAll(Arrays.asList(c1, c2));
		turmaRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		
	}
	
	

}
