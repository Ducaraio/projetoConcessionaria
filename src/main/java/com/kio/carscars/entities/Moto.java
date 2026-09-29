package com.kio.carscars.entities;

import com.kio.carscars.enums.TipoMoto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("moto")
public class Moto extends Veiculos{
	private static final long serialVersionUID = 1L;
	
	private TipoMoto tipo;
	private String modelo;
	private String marca;
	
	public Moto() {
	}
	
	public Moto(Long id, String placa, Integer ano, Double kmrodados, String cor, TipoMoto tipo, String modelo,
			String marca) {
		super(id, placa, ano, kmrodados, cor);
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
	}

	public TipoMoto getTipo() {
		return tipo;
	}

	public void setTipo(TipoMoto tipo) {
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
