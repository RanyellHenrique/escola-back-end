package com.ranyell.escola.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ranyell.escola.Services.exceptions.AuthorizationException;
import com.ranyell.escola.Services.exceptions.DataIntegrityException;
import com.ranyell.escola.Services.exceptions.ObjectNotFoundException;
import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.enums.Perfil;
import com.ranyell.escola.repositories.AlunoRepository;
import com.ranyell.escola.security.UserSS;

@Service
public class AlunoService {
	
	@Autowired
	private BCryptPasswordEncoder cryp;
	
	@Autowired
	private AlunoRepository repo;
	
	public Aluno findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrada Id: " + id + ",tipo: " + Aluno.class.getName()));
	}
	
	@Transactional
	public Aluno insert(Aluno obj) {
		try {
			obj.setSenha(cryp.encode(obj.getSenha()));
			return repo.save(obj); 
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Usuario não pode ser cadastrado, Email repetido.");
		}
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}

	public Aluno update(Aluno obj) {
		Aluno newObj = findById(obj.getId());
		updateData(newObj, obj);
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
	
	public Page<Aluno> findPagePerName(String nome, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByNomeContainingIgnoreCase(nome, pageRequest);
	}

	public void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
	}
	
	public Aluno findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
		Aluno obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Aluno.class.getName());
		}
		return obj;
	}

}
