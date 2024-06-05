package com.example.demo.infrastructure.delivery.dtos;

import java.io.Serializable;

/**
 * UsuarioDto
 */
public record UsuarioDto(String nome, String email, String password) implements Serializable {
}
