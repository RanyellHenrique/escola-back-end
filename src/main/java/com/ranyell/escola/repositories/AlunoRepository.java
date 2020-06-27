package com.ranyell.escola.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ranyell.escola.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	@Transactional(readOnly = true)
	Aluno findByEmail(String email);
	
	Page<Aluno> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
}
