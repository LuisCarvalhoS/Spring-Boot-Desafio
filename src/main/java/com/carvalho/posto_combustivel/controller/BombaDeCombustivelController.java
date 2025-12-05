package com.carvalho.posto_combustivel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.carvalho.posto_combustivel.service.BombaDeCombustivelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombasDeCombustivel")
public class BombaDeCombustivelController {

    private final BombaDeCombustivelService bombaDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombaDeCombustivelService.criar(bombasDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombustivel() {
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombasDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel> buscarBombasDeCombustivelPorId(
            @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombasDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBombasDeCombustivelPorId(
            @PathVariable(name = "id") Integer id) {
        bombaDeCombustivelService.deletarBombaCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterarBombaDeCombustivel(
            @RequestParam(name = "id") Integer id,
            @RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombaDeCombustivelService.alterarBombasDeCombustivel(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
