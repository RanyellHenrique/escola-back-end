package com.ranyell.escola.security;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Disciplina;
import com.ranyell.escola.domain.Curso;
import com.ranyell.escola.domain.Matricula;
import com.ranyell.escola.domain.Resultado;
import com.ranyell.escola.domain.Turma;
import com.ranyell.escola.domain.enums.Perfil;
import com.ranyell.escola.repositories.AlunoRepository;
import com.ranyell.escola.repositories.DisciplinaRepository;
import com.ranyell.escola.repositories.CursoRepository;
import com.ranyell.escola.repositories.MatriculaRepository;
import com.ranyell.escola.repositories.ResultadoRepository;
import com.ranyell.escola.repositories.TurmaRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder cryp;
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private DisciplinaRepository avaliacaoRepository;

	@Autowired
	private ResultadoRepository resultadoRepository;

	public void instantiateTestDatabase() throws ParseException {
		Aluno a1 = new Aluno(null, "Ranyell", "05187022199", "ranyell@gmail.com",   cryp.encode("123"));
		a1.addPerfil(Perfil.ADMIN);
		Aluno a2 = new Aluno(null, "Jorge", "50016466004", "jorge@hotmail.com",  cryp.encode("123"));
		Aluno a3 = new Aluno(null, "Ana", "09957667033", "ana@hotmail.com",   cryp.encode("123"));
		Aluno a4 = new Aluno(null, "Lucas", "59271175034", "lucas@hotmail.com",   cryp.encode("123"));
		Aluno a5 = new Aluno(null, "Pedro", "03438617048", "pedro@hotmail.com",   cryp.encode("123"));
		Aluno a6 = new Aluno(null, "Julia", "20865814082", "julia@hotmail.com",   cryp.encode("123"));
		Aluno a7 = new Aluno(null, "Carla", "01759052078", "carla@hotmail.com",   cryp.encode("123"));
		Aluno a8 = new Aluno(null, "Paulo", "18803636072", "paulo@hotmail.com",   cryp.encode("123"));
		Aluno a9 = new Aluno(null, "Paula", "50814662048", "paula@hotmail.com",   cryp.encode("123"));
		Aluno a10 = new Aluno(null, "Vanessa", "86570846000", "vanessa@hotmail.com",   cryp.encode("123"));
		Aluno a11 = new Aluno(null, "Jessica", "06506697032", "jessica@hotmail.com",   cryp.encode("123"));
		Aluno a12 = new Aluno(null, "Gomes", "45056985058", "gomes@hotmail.com",   cryp.encode("123"));
		
		Aluno a13 = new Aluno(null, "Rafael", "78553935019", "rafael@gmail.com",   cryp.encode("123"));
		Aluno a14 = new Aluno(null, "Ramon", "28939319010", "ramon@gmail.com",  cryp.encode("123"));
		Aluno a15 = new Aluno(null, "Laura", "69115439089", "laura@gmail.com",   cryp.encode("123"));
		Aluno a16 = new Aluno(null, "Pablo", "81662320060", "pablo@gmail.com",   cryp.encode("123"));
		Aluno a17 = new Aluno(null, "Leandro", "39199673053", "leandro@gmail.com",   cryp.encode("123"));
		Aluno a18 = new Aluno(null, "Jorge", "78122062032", "jorge@gmail.com",   cryp.encode("123"));
		Aluno a19 = new Aluno(null, "Camila", "09999094015", "camila@gmail.com",   cryp.encode("123"));
		Aluno a20 = new Aluno(null, "Rebeca", "23630523072", "rebeca@gmail.com",   cryp.encode("123"));

		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20));

		Curso c1 = new Curso(null, "Ciencia da Computação", 3000.0, 7.0);
		Curso c2 = new Curso(null, "Analise e desenvolvimento de sistemas", 1500.0, 5.0);
		Curso c3 = new Curso(null, "Automação Industrial", 1500.0, 5.0);
		Curso c4 = new Curso(null, "Biomedicina", 3000.0, 7.0);
		Curso c5 = new Curso(null, "Ciências Contábeis", 3000.0, 7.0);
		Curso c6 = new Curso(null, "Direito", 4000.0, 7.0);
		Curso c7 = new Curso(null, "Enfermagem", 3000.0, 7.0);
		Curso c8 = new Curso(null, "Engenharia de Computação", 4000.0, 7.0);
		Curso c9 = new Curso(null, "Matemática", 3000.0, 7.0);
		Curso c10 = new Curso(null, "Química", 4000.0, 7.0);
		Curso c11 = new Curso(null, "Física", 3000.0, 7.0);
		Curso c12 = new Curso(null, "Engenharia Civil", 4000.0, 7.0);

		Turma t1 = new Turma(null, new Date(), 60, c1);
		Turma t2 = new Turma(null, new Date(), 55, c1);
		Turma t5 = new Turma(null, new Date(), 42, c1);
		Turma t6 = new Turma(null, new Date(), 43, c1);
		Turma t7 = new Turma(null, new Date(), 31, c1);
		Turma t8 = new Turma(null, new Date(), 27, c1);
		Turma t9 = new Turma(null, new Date(), 15, c1);
		Turma t10 = new Turma(null, new Date(), 28, c1);

		Turma t3 = new Turma(null, new Date(), 50, c2);
		Turma t4 = new Turma(null, new Date(), 45, c2);

		cursoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
		turmaRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));

		Matricula m1 = new Matricula(a2, t2, new Date());
		Matricula m2 = new Matricula(a1, t3, new Date());

		matriculaRepository.saveAll(Arrays.asList(m1, m2));

		Disciplina ava1 = new Disciplina(null, new Date(), 10.0, t1, "Lógica de programação");
		Disciplina ava3 = new Disciplina(null, new Date(), 10.0, t1, "Banco De Dados");
		Disciplina ava4 = new Disciplina(null, new Date(), 10.0, t1, "Orientação a objeto");
		Disciplina ava5 = new Disciplina(null, new Date(), 10.0, t1, "Algebra Linear");
		Disciplina ava6 = new Disciplina(null, new Date(), 10.0, t1, "Estrutura de dados");
		Disciplina ava2 = new Disciplina(null, new Date(), 10.0, t1, "Programação Estruturada");
		Disciplina ava7 = new Disciplina(null, new Date(), 10.0, t1, "Computação gráfica");
		Disciplina ava8 = new Disciplina(null, new Date(), 10.0, t1, "Circuitos Digitais");
		Disciplina ava9 = new Disciplina(null, new Date(), 10.0, t1, "Paradigmas De LInguagens");

		avaliacaoRepository.saveAll(Arrays.asList(ava1, ava2, ava3, ava4, ava5, ava6, ava7, ava8, ava9));

		Resultado r1 = new Resultado(a2, ava2, 8.2);
		Resultado r2 = new Resultado(a1, ava1, 8.7);
		Resultado r3 = new Resultado(a4, ava2, 9.3);
		Resultado r4 = new Resultado(a5, ava1, 8.4);
		Resultado r5 = new Resultado(a1, ava3, 7.5);
		Resultado r6 = new Resultado(a1, ava4, 8.9);
		Resultado r7 = new Resultado(a1, ava5, 6.7);
		Resultado r8 = new Resultado(a1, ava6, 9.2);
		Resultado r9 = new Resultado(a1, ava7, 8.9);
		Resultado r10 = new Resultado(a1, ava8, 6.7);
		Resultado r11 = new Resultado(a1, ava9, 9.2);

		resultadoRepository.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11));
	}
}
