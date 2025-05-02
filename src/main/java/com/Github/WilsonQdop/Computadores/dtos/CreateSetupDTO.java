package com.Github.WilsonQdop.Computadores.dtos;

import java.util.List;

public record CreateSetupDTO(String name, List<HardwareDTO> hardware) {
}
