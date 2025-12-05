package com.carvalho.posto_combustivel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carvalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.carvalho.posto_combustivel.infrastructure.repositories.BombaDeCombustivelRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    public void criar(BombasDeCombustivel bombasDeCombustivel) {
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }

    public BombasDeCombustivel buscarBombasDeCombustivelPorId(Integer id) {
        return bombaDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Bomba de Combustível não encontrada" + id));
    }

    public List<BombasDeCombustivel> buscarBombasDeCombustivel() {
        return bombaDeCombustivelRepository.findAll();
    }

    @Transactional
    public void deletarBombaCombustivel(Integer id) {
        bombaDeCombustivelRepository.deleteById(id);
    }

    public void alterarBombasDeCombustivel(Integer id, BombasDeCombustivel bombasDeCombustivel) {
        BombasDeCombustivel bomba = buscarBombasDeCombustivelPorId(id);
        bombasDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepository.save(bombasDeCombustivel);
    }
} 
