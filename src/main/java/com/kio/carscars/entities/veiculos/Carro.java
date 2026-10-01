package com.kio.carscars.entities.veiculos;

import com.kio.carscars.entities.Concessionaria;
import com.kio.carscars.enums.TipoCarro;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("carro")
public class Carro extends Veiculos{
	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	private TipoCarro tipocarro;
	private String modelo;
	private String marca;
	
	public Carro() {
	}
	
	public Carro( String placa, Integer ano, Double kmrodados, String cor, Concessionaria concessionaria,
			TipoCarro tipocarro, String modelo, String marca) {
		super(placa, ano, kmrodados, cor, concessionaria);
		this.tipocarro = tipocarro;
		this.modelo = modelo;
		this.marca = marca;
	}


	public TipoCarro getTipo() {
		return tipocarro;
	}

	public void setTipo(TipoCarro tipo) {
		this.tipocarro = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
