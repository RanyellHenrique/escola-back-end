package com.ranyell.escola.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ranyell.escola.domain.Resultado;

public class ResultadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Double notaObtida;
	private AlunoDTO aluno;
	private DisciplinaDTO disciplina;
	
	public ResultadoDTO() {
		
	}
	
	public ResultadoDTO(Resultado resultado) {
		this.notaObtida = resultado.getNotaObtida();
		this.aluno = new AlunoDTO(resultado.getAluno());
		this.disciplina = new DisciplinaDTO(resultado.getDisciplina());
	}

	public Double getNotaObtida() {
		return notaObtida;
	}

	public void setNotaObtida(Double notaObtida) {
		this.notaObtida = notaObtida;
	}

	@JsonIgnore
	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

}
