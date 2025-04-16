package com.bootcamp.bacen_service.service;

import com.bootcamp.bacen_service.dto.ChaveDTO;
import com.bootcamp.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.bacen_service.exception.ChaveJaCadastradaException;
import com.bootcamp.bacen_service.exception.ChaveNaoLocalizadaException;
import com.bootcamp.bacen_service.model.Chave;
import com.bootcamp.bacen_service.repository.ChaveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChaveService {

    private final ChaveRepository chaveRepository;

    public ChaveResponseDTO criarChave(final ChaveRequestDTO chaveRequestDTO){

        if (chaveRepository.existsByChave(chaveRequestDTO.getChave())){
            throw new ChaveJaCadastradaException(
                    String.format("A chave: %s já existe no sistema.", chaveRequestDTO.getChave())
            );
        }

        Chave chave = Chave.builder()
                .chave(chaveRequestDTO.getChave())
                .ativa(chaveRequestDTO.getAtiva())
                .build();

        chave = chaveRepository.save(chave);

        return  ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

    public List<ChaveDTO> buscarTodasChaves() {
        return chaveRepository.findAll().stream()
                .map(chave -> ChaveDTO.builder()
                        .id(chave.getId())
                        .chave(chave.getChave())
                        .ativa(chave.getAtiva())
                        .build())
                .collect(Collectors.toList());
    }

    public ChaveResponseDTO buscarChave(final String chavePesquisada){
        Chave chave = chaveRepository.findByChave(chavePesquisada).orElseThrow(
                () -> new ChaveNaoLocalizadaException(
                        String.format("A chave: %s não existe no sistema.", chavePesquisada)
                ));

        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();

    }

    public ChaveResponseDTO atualizaChave(final ChaveRequestDTO chaveRequestDTO, UUID id){
        Chave chaveExistente = chaveRepository.findById(id)
                .orElseThrow(() -> new ChaveNaoLocalizadaException("A chave não existe."));

        chaveExistente.setChave(chaveRequestDTO.getChave());
        chaveExistente.setAtiva(chaveRequestDTO.getAtiva());

        chaveExistente = chaveRepository.save(chaveExistente);

        return ChaveResponseDTO.builder()
                .chave(chaveExistente.getChave())
                .ativa(chaveExistente.getAtiva())
                .build();
    }

    public void deletarChave(UUID id){
        chaveRepository.findById(id).orElseThrow(() -> new ChaveNaoLocalizadaException("Chave não existe."));
        chaveRepository.deleteById(id);
    }

}
