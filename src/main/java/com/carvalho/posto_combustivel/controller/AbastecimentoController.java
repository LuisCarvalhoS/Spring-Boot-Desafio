package com.carvalho.posto_combustivel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.posto_combustivel.infrastructure.entities.Abastecimento;
import com.carvalho.posto_combustivel.service.AbastecimentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    @PostMapping
    public ResponseEntity<Void> abastecer(
            @RequestParam("quantidadeEmLitros") Long litros,
            @RequestParam("idBomba") Integer idBomba) {

        abastecimentoService.abastecer(idBomba, litros);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarAbastecimentos() {
        return ResponseEntity.ok(abastecimentoService.buscarAbastecimentos());
    }
}
