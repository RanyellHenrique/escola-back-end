package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.AuthorizationException;
import com.ranyell.escola.Services.exceptions.DataIntegrityException;
import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Disciplina;
import com.ranyell.escola.domain.enums.Perfil;
import com.ranyell.escola.repositories.DisciplinaRepository;
import com.ranyell.escola.security.UserSS;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;
	
	@Autowired
	private TurmaService turmaService;

	public Disciplina findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Disciplina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Disciplina não encontrada Id: " + id + ", tipo: " + Disciplina.class.getName()));
	}

	@Transactional
	public Disciplina insert(Disciplina obj) {
		return repo.save(obj);
	}

	public List<Disciplina> findAll() {
		return repo.findAll();
	}

	public Disciplina update(Disciplina obj) {
		Disciplina newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um aluno que possui matricula e Disciplina");
		}
	}

	public Page<Disciplina> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public void updateData(Disciplina newObj, Disciplina obj) {
		newObj.setData(obj.getData());
		newObj.setId(obj.getId());
		newObj.setNota(obj.getNota());
		newObj.setTurma(turmaService.findById(obj.getTurma().getId()));
	}

}
