package com.Github.WilsonQdop.Computadores.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record UsersDTO(
        @NotBlank(message = "Nome está vázio")
        String name,
        @NotBlank (message = "Nome está vázio")
        @Column(unique = true)
        String email,
        @NotBlank (message = "Nome está vázio")
        String password) { }
