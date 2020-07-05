package com.ranyell.escola.dto;

import java.io.Serializable;

import com.ranyell.escola.domain.Curso;

public class CursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double cargaHoraria;
	private Double notaMinima;
	
	public CursoDTO(){
		
	}

	public CursoDTO(Curso curso) {
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.cargaHoraria = curso.getCargaHoraria();
		this.notaMinima = curso.getNotaMinima();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Double getNotaMinima() {
		return notaMinima;
	}

	public void setNotaMinima(Double notaMinima) {
		this.notaMinima = notaMinima;
	}
	
}
