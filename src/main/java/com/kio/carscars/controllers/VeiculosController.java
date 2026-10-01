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

import com.kio.carscars.entities.veiculos.Carro;
import com.kio.carscars.entities.veiculos.Moto;
import com.kio.carscars.entities.veiculos.Veiculos;
import com.kio.carscars.services.VeiculosService;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
	
	private final VeiculosService service;
	
	VeiculosController(VeiculosService service){
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculos>> findAll(){
		List<Veiculos> veiculos = service.findAll();
		return ResponseEntity.ok().body(veiculos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculos> findById(@PathVariable Long id){
		Veiculos veiculo = service.findById(id);
		return ResponseEntity.ok().body(veiculo);
	}
	
	@GetMapping("/carros")
	public ResponseEntity<List<Carro>> findAllCarros(){
		List<Carro> carros = service.findAllCarros();
		return ResponseEntity.ok().body(carros);
	}
	
	@GetMapping("/motos")
	public ResponseEntity<List<Moto>> findAllMotos(){
		List<Moto> motos = service.findAllMotos();
		return ResponseEntity.ok().body(motos);
	}
	
	@PostMapping("/carro")
	public ResponseEntity<Carro> insertCarro(@RequestBody Carro carro){
		carro = service.insertCarro(carro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(carro);
	}
	
	@PostMapping("/moto")
	public ResponseEntity<Moto> insertMoto(@RequestBody Moto moto){
		moto = service.insertMoto(moto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(moto.getId()).toUri();
		return ResponseEntity.created(uri).body(moto);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculos> update(@RequestBody Veiculos novo, @PathVariable Long id){
		novo = service.update(id, novo);
		return ResponseEntity.ok().body(novo);
	}
}
