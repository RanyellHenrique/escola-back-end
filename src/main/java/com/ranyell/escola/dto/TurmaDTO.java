package com.ranyell.escola.dto;

import java.io.Serializable;
import java.util.Date;

import com.ranyell.escola.domain.Turma;

public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private Integer numeroDeVagas;
	
	public TurmaDTO(Turma turma) {
		this.id = turma.getId();
		this.data = turma.getData();
		this.numeroDeVagas = turma.getNumeroDeVagas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNumeroDeVagas() {
		return numeroDeVagas;
	}

	public void setNumeroDeVagas(Integer numeroDeVagas) {
		this.numeroDeVagas = numeroDeVagas;
	}
	
}
