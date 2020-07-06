package com.ranyell.escola.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ranyell.escola.domain.pk.ResultadoPK;

@Entity
public class Resultado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ResultadoPK id = new ResultadoPK();
	private Double notaObtida;
	
	public Resultado() {
		
	}
	
	public Resultado(Aluno aluno, Disciplina disciplina, Double notaObtida) {
		id.setAluno(aluno);
		id.setDisciplina(disciplina);
		this.notaObtida = notaObtida;
	}

	public Double getNotaObtida() {
		return notaObtida;
	}

	public void setNotaObtida(Double notaObtida) {
		this.notaObtida = notaObtida;
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	@JsonIgnore
	public Disciplina getDisciplina() {
		return id.getDisciplina();
	}
	
	public void setDisciplina(Disciplina avaliacao) {
		id.setDisciplina(avaliacao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
