package com.carvalho.posto_combustivel.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.carvalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.carvalho.posto_combustivel.infrastructure.repositories.AbastecimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AbastacimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros) {
        BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombasDeCombustivelPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));
    }

}
