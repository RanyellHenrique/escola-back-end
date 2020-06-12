package com.ranyell.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranyell.escola.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
