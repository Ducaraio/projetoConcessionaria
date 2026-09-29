package com.kio.carscars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kio.carscars.entities.veiculos.Veiculos;

public interface VeiculoRepository extends JpaRepository<Veiculos, Long> {
}
