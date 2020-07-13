package com.ranyell.escola.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ranyell.escola.domain.Aluno;

public class AlunoDetailsDTO extends AlunoDTO {
	private static final long serialVersionUID = 1L;
	
	private List<ResultadoDTO> resultados = new ArrayList<>(); 
	private List<MatriculaDTO> matriculas = new ArrayList<>();
	
	public AlunoDetailsDTO() {
	}
	
	public AlunoDetailsDTO(Aluno aluno) {
		super(aluno);
		this.resultados = aluno.getResultados().stream().map(x -> new ResultadoDTO(x)).collect(Collectors.toList());
		this.matriculas = aluno.getmatriculas().stream().map(x -> new MatriculaDTO(x)).collect(Collectors.toList());
	}

	public List<ResultadoDTO> getResultados() {
		return resultados;
	}

	public void setResultados(List<ResultadoDTO> resultados) {
		this.resultados = resultados;
	}

	public List<MatriculaDTO> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<MatriculaDTO> matriculas) {
		this.matriculas = matriculas;
	}
	
}
