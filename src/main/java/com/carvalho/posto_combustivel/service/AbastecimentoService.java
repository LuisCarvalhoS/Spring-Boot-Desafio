package com.carvalho.posto_combustivel.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carvalho.posto_combustivel.infrastructure.entities.Abastecimento;
import com.carvalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.carvalho.posto_combustivel.infrastructure.repositories.AbastecimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros) {
        BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombasDeCombustivelPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel()
                .getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombasDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos() {
        return abastecimentoRepository.findAll();
    }
}
