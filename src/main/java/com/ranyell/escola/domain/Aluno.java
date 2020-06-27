package com.ranyell.escola.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.ranyell.escola.domain.enums.Perfil;


@Entity
public class Aluno  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 e 80 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	@CPF(message = "CPF Inválido.")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String senha;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "Email Inválido.")
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "id.aluno")
	private Set<Matricula> matriculas = new HashSet<>();
	
	@OneToMany(mappedBy = "id.aluno")
	private List<Resultado> resultados = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	public Aluno() {
		addPerfil(Perfil.USUARIO);
	}

	public Aluno(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.USUARIO);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Matricula> getmatriculas(){
		return matriculas;
	}
	
	public List<Resultado> getResultados(){
		return resultados;
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
