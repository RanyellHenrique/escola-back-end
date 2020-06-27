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
import com.ranyell.escola.domain.Avaliacao;
import com.ranyell.escola.domain.enums.Perfil;
import com.ranyell.escola.repositories.AvaliacaoRepository;
import com.ranyell.escola.security.UserSS;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repo;
	
	@Autowired
	private TurmaService turmaService;

	public Avaliacao findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Avaliacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Avaliação não encontrada Id: " + id + ", tipo: " + Avaliacao.class.getName()));
	}

	@Transactional
	public Avaliacao insert(Avaliacao obj) {
		return repo.save(obj);
	}

	public List<Avaliacao> findAll() {
		return repo.findAll();
	}

	public Avaliacao update(Avaliacao obj) {
		Avaliacao newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um aluno que possui matricula e avaliações");
		}
	}

	public Page<Avaliacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public void updateData(Avaliacao newObj, Avaliacao obj) {
		newObj.setData(obj.getData());
		newObj.setId(obj.getId());
		newObj.setNota(obj.getNota());
		newObj.setTurma(turmaService.findById(obj.getTurma().getId()));
	}

}
