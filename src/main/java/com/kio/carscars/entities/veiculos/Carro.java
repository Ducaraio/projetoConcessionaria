package com.kio.carscars.entities.veiculos;

import com.kio.carscars.enums.TipoCarro;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("carro")
public class Carro extends Veiculos{
	private static final long serialVersionUID = 1L;
	
	private TipoCarro tipo;
	private String modelo;
	private String marca;
	
	public Carro() {
	}
	
	public Carro(Long id, String placa, Integer ano, Double kmrodados, String cor, TipoCarro tipo, String modelo,
			String marca) {
		super(id, placa, ano, kmrodados, cor);
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
	}

	public TipoCarro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
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
