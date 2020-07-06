package com.ranyell.escola.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ranyell.escola.domain.Curso;

public class CursoDetailsDTO extends CursoDTO{
	private static final long serialVersionUID = 1L;
	
	private List<TurmaDTO> turmas = new ArrayList<>();
	
	public CursoDetailsDTO() {
		
	}
	
	public CursoDetailsDTO(Curso curso) {
		super(curso);
		this.turmas = curso.getTurmas().stream().map(x -> new TurmaDTO(x)).collect(Collectors.toList());
	}

	public List<TurmaDTO> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaDTO> turmas) {
		this.turmas = turmas;
	}

}
