package com.carvalho.posto_combustivel.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvalho.posto_combustivel.infrastructure.entities.TiposDeCombustivel;

public interface TipoDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer>{

}
