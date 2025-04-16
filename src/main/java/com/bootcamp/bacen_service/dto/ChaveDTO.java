package com.bootcamp.bacen_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class ChaveDTO {
    private UUID id;
    private String chave;
    private Boolean ativa;
}
