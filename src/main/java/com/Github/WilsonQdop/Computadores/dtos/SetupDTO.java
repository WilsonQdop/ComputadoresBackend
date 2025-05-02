package com.Github.WilsonQdop.Computadores.dtos;

import com.Github.WilsonQdop.Computadores.models.Hardware;

import java.util.List;

public record SetupDTO (Integer setupId, String name, List<HardwareDTO> hardware) {
}
