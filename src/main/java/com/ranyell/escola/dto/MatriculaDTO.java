package com.ranyell.escola.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ranyell.escola.domain.Matricula;

public class MatriculaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private AlunoDTO aluno;
	private TurmaDTO turma;
	private Date data;
	
	public MatriculaDTO() {
		
	}
	
	public MatriculaDTO(Matricula matricula) {
		this.aluno = new AlunoDTO(matricula.getAluno());
		this.turma = new TurmaDTO(matricula.getTurma());
		this.data = matricula.getData();
	}

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	@JsonIgnore
	public TurmaDTO getTurma() {
		return turma;
	}

	public void setTurma(TurmaDTO turma) {
		this.turma = turma;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
