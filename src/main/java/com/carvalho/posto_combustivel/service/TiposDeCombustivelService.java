package com.carvalho.posto_combustivel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carvalho.posto_combustivel.infrastructure.entities.TiposDeCombustivel;
import com.carvalho.posto_combustivel.infrastructure.repositories.TipoDeCombustivelRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TipoDeCombustivelRepository tipoDeCombustivelRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel) {
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id) {
        return tipoDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Tipo de Combustível não encontrada" + id));
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel() {
        return tipoDeCombustivelRepository.findAll();
    } 

    @Transactional
    public void deletarTipoDeCombustivel(Integer id) {
        tipoDeCombustivelRepository.deleteById(id);
    }

    public void alterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel) {

        tiposDeCombustivel.setId(id);
        tipoDeCombustivelRepository.save(tiposDeCombustivel);
    }
}
