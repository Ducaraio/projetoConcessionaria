package com.kio.carscars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kio.carscars.entities.veiculos.Carro ;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
