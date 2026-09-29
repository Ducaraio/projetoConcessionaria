package com.kio.carscars.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.kio.carscars.entities.veiculos.Veiculos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_concessionaria" , uniqueConstraints = {@UniqueConstraint (columnNames = {"cep", "nome"})})
public class Concessionaria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String nome;
	
	@OneToMany(mappedBy = "concessionaria", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Veiculos> veiculos = new HashSet<>();
	
	public Concessionaria() {
	}
	
	public Concessionaria(Long id, String cep, String nome) {
		super();
		this.id = id;
		this.cep = cep;
		this.nome = nome;
	}
	
	public Set<Veiculos> getVeiculos() {
		return veiculos;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concessionaria other = (Concessionaria) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	

}
