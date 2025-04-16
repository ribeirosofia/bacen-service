package com.bootcamp.bacen_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor

public class ChaveResponseDTO {
    private String chave;
    private Boolean ativa;
}
