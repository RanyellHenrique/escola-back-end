package com.ranyell.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranyell.escola.domain.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

}
