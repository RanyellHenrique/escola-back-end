package com.ranyell.escola.domain.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Avaliacao;

@Embeddable
public class ResultadoPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "avaliacao_id")
	private Avaliacao avaliacao;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((avaliacao == null) ? 0 : avaliacao.hashCode());
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
		ResultadoPK other = (ResultadoPK) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		return true;
	}

}
