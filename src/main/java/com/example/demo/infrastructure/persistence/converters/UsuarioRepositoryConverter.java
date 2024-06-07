package com.example.demo.infrastructure.persistence.converters;

import org.springframework.stereotype.Component;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.infrastructure.persistence.entities.UsuarioEntity;
import com.example.demo.infrastructure.shared.RepositoryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UsuarioRepositoryConverter
 */
@Component
public class UsuarioRepositoryConverter implements RepositoryConverter<UsuarioEntity, Usuario> {

  private final static Logger logger = LoggerFactory.getLogger(UsuarioRepositoryConverter.class);

  @Override
  public UsuarioEntity mapToTable(Usuario persistenceObject) {
    var usuario = new UsuarioEntity(persistenceObject.getId(),
        persistenceObject.getNome(),
        persistenceObject.getEmail(),
        persistenceObject.getPassword());
    logger.info("Mapped usuario to entity {}", usuario);
    return usuario;
  }

  @Override
  public Usuario mapToEntity(UsuarioEntity tableObject) {
    var usuario = new Usuario(tableObject.getId(),
        tableObject.getNome(),
        tableObject.getEmail(),
        tableObject.getSenha());
    logger.info("Mapped usuario to domain {}", usuario);
    return usuario;

  }
}
