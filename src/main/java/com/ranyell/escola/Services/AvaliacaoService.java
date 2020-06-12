package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Avaliacao;
import com.ranyell.escola.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository repo;
	
	public List<Avaliacao> findAll(){
		return repo.findAll();
	}
	
	public Avaliacao findById(Integer id) {
		Optional<Avaliacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Avaliação não encontrada! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}

}
