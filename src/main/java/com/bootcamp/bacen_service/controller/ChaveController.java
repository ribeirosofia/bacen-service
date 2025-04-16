package com.bootcamp.bacen_service.controller;


import com.bootcamp.bacen_service.dto.ChaveDTO;
import com.bootcamp.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.bacen_service.service.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api/bacen/chaves")
@RestController
@RequiredArgsConstructor

public class ChaveController {

    private final ChaveService chaveService;

    @PostMapping

    public ResponseEntity<ChaveResponseDTO> criarChave(@RequestBody ChaveRequestDTO chaveRequestDTO){
        return ResponseEntity.status(CREATED).body(chaveService.criarChave(chaveRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ChaveDTO>> buscarTodasChaves(){
        return ResponseEntity.ok(chaveService.buscarTodasChaves());
    }

    @GetMapping("/{chave}")

    public ResponseEntity<ChaveResponseDTO> buscarChave(@PathVariable String chave){
        return ResponseEntity.status(CREATED).body(chaveService.buscarChave(chave));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChaveResponseDTO> atualizaChave(
            @RequestBody ChaveRequestDTO chaveRequestDTO,
            @PathVariable UUID id) {
        return ResponseEntity.ok(chaveService.atualizaChave(chaveRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChave(@PathVariable UUID id){
        chaveService.deletarChave(id);
        return ResponseEntity.noContent().build();
    }

}
