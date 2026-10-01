package com.kio.carscars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kio.carscars.entities.veiculos.Moto ;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
