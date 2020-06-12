package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
	
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName())); 
	}

}
