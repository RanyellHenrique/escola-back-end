package com.ranyell.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranyell.escola.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
