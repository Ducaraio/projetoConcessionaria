package com.kio.carscars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kio.carscars.entities.veiculos.Carro;
import com.kio.carscars.entities.veiculos.Moto;
import com.kio.carscars.entities.veiculos.Veiculos;
import com.kio.carscars.repositories.VeiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class VeiculosService {
	
	private final VeiculoRepository repository;
	
	VeiculosService(VeiculoRepository repository){
		this.repository = repository;
	}
	
	public List<Veiculos> findAll(){
		return repository.findAll();
	}
	
	public Veiculos findById(Long id) {
		Optional<Veiculos> vei = repository.findById(id);
		return vei.get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Veiculos insert(Veiculos veiculo) {
		return repository.save(veiculo);
	}
	
	public Veiculos findByPlaca(String placa) {
		List<Veiculos> vei = repository.findAll();
		return vei.stream().filter(x -> x.getPlaca().equalsIgnoreCase(placa)).findFirst()
		.orElseThrow(() -> new RuntimeException("placa inexistente"));
	}
	
	@Transactional
	public Veiculos update(Long id, Veiculos novo) {
		Veiculos velho = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Veiculo não encontrado."));
		updateData(velho, novo);
		return repository.save(velho);
	}
	
	private void updateData(Veiculos velho, Veiculos novo){
		velho.setAno(novo.getAno());
		velho.setConcessionaria(novo.getConcessionaria());
		velho.setKmrodados(novo.getKmrodados());
		velho.setCor(novo.getCor());
		if(velho instanceof Carro carro && novo instanceof Carro carroEnviado) {
			carro.setMarca(carroEnviado.getMarca());
			carro.setModelo(carroEnviado.getModelo());
			carro.setTipo(carroEnviado.getTipo());
		}else if(velho instanceof Moto moto && novo instanceof Moto motoEnviada) {
			moto.setMarca(motoEnviada.getMarca());
			moto.setModelo(motoEnviada.getModelo());
			moto.setTipo(moto.getTipo());
		}
	}
}
