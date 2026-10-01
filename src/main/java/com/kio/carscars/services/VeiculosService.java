package com.kio.carscars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kio.carscars.entities.veiculos.Carro;
import com.kio.carscars.entities.veiculos.Moto;
import com.kio.carscars.entities.veiculos.Veiculos;
import com.kio.carscars.repositories.CarroRepository;
import com.kio.carscars.repositories.MotoRepository;
import com.kio.carscars.repositories.VeiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class VeiculosService {
	private final MotoRepository motoRepo;
	private final CarroRepository carroRepo;
	private final VeiculoRepository veiculoRepo;
	
	VeiculosService(VeiculoRepository veiculoRepo, CarroRepository carroRepo, MotoRepository motoRepo){
		this.veiculoRepo = veiculoRepo;
		this.carroRepo = carroRepo;
		this.motoRepo = motoRepo;
	}
	
	public List<Veiculos> findAll(){
		return veiculoRepo.findAll();
	}
	
	public Veiculos findById(Long id) {
		Optional<Veiculos> vei = veiculoRepo.findById(id);
		return vei.get();
	}
	
	public List<Carro> findAllCarros(){
		return carroRepo.findAll();
	}
	
	public List<Moto> findAllMotos(){
		return motoRepo.findAll();
	}
	
	public Carro insertCarro(Carro carro) {
		return carroRepo.save(carro);
	}
	
	public Moto insertMoto(Moto moto) {
		return motoRepo.save(moto);
	}
	
	public void delete(Long id) {
		veiculoRepo.deleteById(id);
	}
	
	public Veiculos insert(Veiculos veiculo) {
		return veiculoRepo.save(veiculo);
	}
	
	public Veiculos findByPlaca(String placa) {
		List<Veiculos> vei = veiculoRepo.findAll();
		return vei.stream().filter(x -> x.getPlaca().equalsIgnoreCase(placa)).findFirst()
		.orElseThrow(() -> new RuntimeException("placa inexistente"));
	}
	
	@Transactional
	public Veiculos update(Long id, Veiculos novo) {
		Veiculos velho = veiculoRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Veiculo não encontrado."));
		updateData(velho, novo);
		return veiculoRepo.save(velho);
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
			moto.setTipo(motoEnviada.getTipo());
		}
	}
}
