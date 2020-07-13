package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Aluno;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Curso não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
	
	public Page<Curso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Page<Curso> findPagePerName(String nome, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByNomeContainingIgnoreCase(nome, pageRequest);
	}
	
	public Curso insert(Curso obj) {
		return repo.save(obj);
	}

}
