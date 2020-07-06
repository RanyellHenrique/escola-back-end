package com.ranyell.escola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranyell.escola.Services.DisciplinaService;
import com.ranyell.escola.domain.Disciplina;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService service;
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll(){
		List<Disciplina> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id){
		Disciplina obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
