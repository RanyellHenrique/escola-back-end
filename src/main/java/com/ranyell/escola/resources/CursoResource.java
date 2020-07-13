package com.ranyell.escola.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ranyell.escola.Services.CursoService;
import com.ranyell.escola.domain.Aluno;
import com.ranyell.escola.domain.Curso;
import com.ranyell.escola.dto.CursoDTO;
import com.ranyell.escola.dto.CursoDetailsDTO;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CursoDetailsDTO> findById(@PathVariable Integer id){
		CursoDetailsDTO obj = new CursoDetailsDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CursoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Curso> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CursoDTO> listDto = list.map(obj -> new CursoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/page/search")
	public ResponseEntity<Page<CursoDTO>> findPagePerName(
			@RequestParam(value = "search", defaultValue = "") String nome,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Curso> list = service.findPagePerName(nome, page, linesPerPage, orderBy, direction);
		Page<CursoDTO> listDto = list.map(obj -> new CursoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Curso obj ){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
