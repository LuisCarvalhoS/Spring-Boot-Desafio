package com.carvalho.posto_combustivel.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;

public interface BombaDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer>{

}
