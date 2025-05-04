package com.Github.WilsonQdop.Computadores.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateNameSetup (@NotBlank(message = "Nome não pode está vazio") String name) {
}
