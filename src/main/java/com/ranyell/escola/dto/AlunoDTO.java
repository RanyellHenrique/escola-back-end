package com.ranyell.escola.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.ranyell.escola.domain.Aluno;

public class AlunoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 e 80 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	@CPF(message = "CPF Inválido.")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "Email Inválido.")
	private String email;
	
	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf  = obj.getCpf();
		this.email = obj.getEmail();
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

}
