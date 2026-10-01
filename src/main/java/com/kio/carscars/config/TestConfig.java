package com.kio.carscars.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kio.carscars.entities.Concessionaria;
import com.kio.carscars.entities.veiculos.Carro;
import com.kio.carscars.entities.veiculos.Moto;
import com.kio.carscars.entities.veiculos.Veiculos;
import com.kio.carscars.enums.TipoCarro;
import com.kio.carscars.enums.TipoMoto;
import com.kio.carscars.repositories.CarroRepository;
import com.kio.carscars.repositories.ConcessionariaRepository;
import com.kio.carscars.repositories.MotoRepository;
import com.kio.carscars.repositories.VeiculoRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	private final VeiculoRepository veiculoRepository;
	private final MotoRepository motoRepository;
	private final CarroRepository carroRepository;
	private final ConcessionariaRepository conRepository;
	
	TestConfig(VeiculoRepository veiculoRepository, MotoRepository motoRepository, CarroRepository carroRepository
			, ConcessionariaRepository conRepository) {
		this.veiculoRepository = veiculoRepository;
		this.motoRepository = motoRepository;
		this.carroRepository = carroRepository;
		this.conRepository = conRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Concessionaria con1 = new Concessionaria("01923810923801283", "Casablanca");
		Concessionaria con2 = new Concessionaria("1902937102983", "NewsVeiculos");
		
		conRepository.saveAll(Arrays.asList(con1, con2));
		
		Veiculos v1 = new Carro("abc-1234", 2010, 150000.0,"branco", con1, TipoCarro.HATCH , "Uno vivace", "Fiat");
		Veiculos v2 = new Moto("bca-4321", 2011, 300000.0, "vermelha", con2, TipoMoto.SCOOTER, "motoquinha", "yamaha");
		Veiculos v3 = new Carro("poe-6369", 2026, 0.0, "rosa", con2, TipoCarro.HATCH, "dolphin mini", "byd");
		Veiculos v4 = new Moto("qwe-6544", 2022, 10000.0, "preto", con1, TipoMoto.OFF_ROAD, "CRF250", "Honda");
		
		veiculoRepository.saveAll(Arrays.asList(v1,v2,v3,v4));
	}
}
