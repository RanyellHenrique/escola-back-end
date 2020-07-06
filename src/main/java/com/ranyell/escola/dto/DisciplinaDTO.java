package com.ranyell.escola.dto;

import java.io.Serializable;
import java.util.Date;

import com.ranyell.escola.domain.Disciplina;

public class DisciplinaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Date data;
	private Double nota;
	
	public DisciplinaDTO() {
		
	}
	
	public DisciplinaDTO(Disciplina disciplina) {
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
		this.data = disciplina.getData();
		this.nota = disciplina.getNota();
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	

}
