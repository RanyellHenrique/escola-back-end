package com.ranyell.escola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranyell.escola.Services.AvaliacaoService;
import com.ranyell.escola.domain.Avaliacao;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService service;
	
	@GetMapping
	public ResponseEntity<List<Avaliacao>> findAll(){
		List<Avaliacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Avaliacao> findById(@PathVariable Integer id){
		Avaliacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
