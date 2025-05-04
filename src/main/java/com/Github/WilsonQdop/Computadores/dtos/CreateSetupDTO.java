package com.Github.WilsonQdop.Computadores.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateSetupDTO(
        @NotBlank(message = "Nome do setup não informado")
        String name,
        List<HardwareDTO> hardware) {
}
