package com.ranyell.escola.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.ranyell.escola.domain.pk.MatriculaPK;

@Entity
public class Matricula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();
	private Date data;
	
	public Matricula() {
		
	}
	
	public Matricula(Aluno aluno, Turma turma, Date data) {
		id.setAluno(aluno);
		id.setTurma(turma);
		this.data = data;
	}
	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public Turma getTurma() {
		return id.getTurma();
	}
	
	public void setTurma(Turma turma) {
		id.setTurma(turma);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
