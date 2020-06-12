package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Turma;
import com.ranyell.escola.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repo;
	
	public List<Turma> findAll(){
		return repo.findAll();
	}
	
	public Turma findById(Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Turma não encontrada! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}

}
