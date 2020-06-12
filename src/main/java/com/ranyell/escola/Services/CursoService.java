package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.escola.domain.Curso;
import com.ranyell.escola.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repo;
	
	public List<Curso> findAll(){
		return repo.findAll();
	}
	
	public Curso findById(Integer id) {
		Optional<Curso> obj = repo.findById(id);
		return obj.get();
	}

}
