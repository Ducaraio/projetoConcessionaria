package com.kio.carscars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kio.carscars.entities.Concessionaria;
import com.kio.carscars.repositories.ConcessionariaRepository;

@Service
public class ConcessionariasService {
	
	private final ConcessionariaRepository repository;
	
	ConcessionariasService(ConcessionariaRepository repository) {
		this.repository = repository;
	}
	
	public List<Concessionaria> findAll(){
		return repository.findAll();
	}
	
	public Concessionaria findById(Long id) {
		Optional<Concessionaria> con = repository.findById(id);
		return con.get();
	}
	
	
	public Concessionaria findByNome(String nome) {
		List<Concessionaria> con = repository.findAll();
		return con.stream().filter(x -> x.getNome().equalsIgnoreCase(nome)).findFirst()
		.orElseThrow(() -> new RuntimeException("Concessionaria não encontrada"));
	}
	
	public Concessionaria insert(Concessionaria con) {
		return repository.save(con);
	}
	
	public void delete(Concessionaria con) {
		repository.delete(con);
	}
	
	public Concessionaria update(Long id, Concessionaria nova) {
		Concessionaria velha = repository.getReferenceById(id);
		updateData(velha, nova);
		return repository.save(velha);
	}
	
	private void updateData(Concessionaria velha, Concessionaria nova) {
		velha.setNome(nova.getNome());
		velha.setCep(nova.getCep());
	}
	
}
