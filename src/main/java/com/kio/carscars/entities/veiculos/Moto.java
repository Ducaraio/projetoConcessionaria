package com.kio.carscars.entities.veiculos;

import com.kio.carscars.entities.Concessionaria;
import com.kio.carscars.enums.TipoMoto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("moto")
public class Moto extends Veiculos{
	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	private TipoMoto tipomoto;
	private String modelo;
	private String marca;
	
	public Moto() {
	}

	public Moto(String placa, Integer ano, Double kmrodados, String cor, Concessionaria concessionaria,
			TipoMoto tipomoto, String modelo, String marca) {
		super(placa, ano, kmrodados, cor, concessionaria);
		this.tipomoto = tipomoto;
		this.modelo = modelo;
		this.marca = marca;
	}



	public TipoMoto getTipo() {
		return tipomoto;
	}

	public void setTipo(TipoMoto tipo) {
		this.tipomoto = tipo;
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
