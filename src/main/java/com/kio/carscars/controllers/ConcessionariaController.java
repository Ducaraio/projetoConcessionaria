package com.kio.carscars.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kio.carscars.entities.Concessionaria;
import com.kio.carscars.services.ConcessionariasService;

@RestController
@RequestMapping(value = "/conc")
public class ConcessionariaController {
	
	private ConcessionariasService service;
	
	public ConcessionariaController(ConcessionariasService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Concessionaria>> findAll(){
		List<Concessionaria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("nome/{nome}")
	public ResponseEntity<Concessionaria> findByNome(@PathVariable String nome){
		Concessionaria con = service.findByNome(nome);
		return ResponseEntity.ok().body(con);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Concessionaria> findById(@PathVariable Long id){
		Concessionaria con = service.findById(id);
		return ResponseEntity.ok().body(con);
	}
	
	@PostMapping
	public ResponseEntity<Concessionaria> insert(@RequestBody Concessionaria con){
		con = service.insert(con);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(con.getId()).toUri();
		return ResponseEntity.created(uri).body(con);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(null);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Concessionaria> update(@RequestBody Concessionaria con, @PathVariable Long id){
		con = service.update(id, con);
		return ResponseEntity.ok().body(con);
	}
}
