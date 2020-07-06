package com.ranyell.escola.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Integer numeroDeVagas;
	
	@ManyToOne
	private Curso curso;
	
	@OneToMany(mappedBy = "id.turma")
	private Set<Matricula> matriculas = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma")
	List<Disciplina> disciplinas = new ArrayList<>();
	
	public Turma() {
		
	}

	public Turma(Integer id, Date data, Integer numeroDeVagas, Curso curso) {
		super();
		this.id = id;
		this.data = data;
		this.numeroDeVagas = numeroDeVagas;
		this.curso = curso;
	}
	
	public Set<Matricula> getMatriculas(){
		return matriculas;
	}
	
	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
