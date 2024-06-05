package com.example.demo.infrastructure.persistence.repositories;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infrastructure.persistence.entities.ProdutoEntity;

/**
 * ProdutoRepository
 */
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
  Collection<ProdutoEntity> findByNome(String nome);

  Collection<ProdutoEntity> findByPreco(BigDecimal preco);

  Collection<ProdutoEntity> findByCategoria(String categoria);
}
