package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.DataIntegrityException;
import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.dto.AlunoDTO;
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

	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Aluno update(Aluno obj) {
		findById(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);	
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um aluno que possui matricula e avaliações");
		}
		
	}
	
	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Aluno fromDTO(AlunoDTO objDto) {
		return new Aluno(objDto.getId(), objDto.getNome(), objDto.getCpf(), objDto.getEmail());
	}

}
