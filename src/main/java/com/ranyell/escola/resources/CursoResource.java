package com.ranyell.escola.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranyell.escola.Services.CursoService;
import com.ranyell.escola.domain.Curso;
import com.ranyell.escola.dto.CursoDTO;

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
	public ResponseEntity<Curso> findById(@PathVariable Integer id){
		Curso obj = service.findById(id);
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
}
