package com.example.demo.infrastructure.delivery.converters;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.infrastructure.delivery.dtos.UsuarioDto;
import com.example.demo.infrastructure.shared.RestConverter;

/**
 * UsuarioRestConverter
 */
public class UsuarioRestConverter implements RestConverter<UsuarioDto, Usuario> {
  @Override
  public Usuario mapToEntity(UsuarioDto rest) {
    return new Usuario(null, rest.nome(), rest.email(), rest.password());
  }

  @Override
  public UsuarioDto mapRoRest(Usuario entiry) {
    return new UsuarioDto(entiry.getNome(), entiry.getEmail(), entiry.getPassword());
  }
}
