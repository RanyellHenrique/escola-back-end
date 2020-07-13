package com.ranyell.escola.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ranyell.escola.domain.Turma;

public class TurmaDetailsDTO extends TurmaDTO{
	private static final long serialVersionUID = 1L;
	
	private CursoDTO curso;
	private List<MatriculaDTO> matriculas = new ArrayList<>();

	public TurmaDetailsDTO(Turma turma) {
		super(turma);
		this.setCurso(new CursoDTO(turma.getCurso()));
		this.setMatriculas(turma.getMatriculas().stream().map(x -> new MatriculaDTO(x)).collect(Collectors.toList()));
	}
	
	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}
	
	public List<MatriculaDTO> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<MatriculaDTO> matriculas) {
		this.matriculas = matriculas;
	}



}
