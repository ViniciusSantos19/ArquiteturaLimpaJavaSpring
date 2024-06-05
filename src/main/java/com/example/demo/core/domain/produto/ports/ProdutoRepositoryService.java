package com.example.demo.core.domain.produto.ports;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import com.example.demo.core.domain.produto.Produto;

/**
 * ProdutoRepositoryService
 */
public interface ProdutoRepositoryService {

  public Optional<Produto> findById(Long id);

  public void delete(Long id);

  public void save(Produto produto);

  public Collection<Produto> findAll();

  public Collection<Produto> findByNome(String nome);

  public Collection<Produto> findByPreco(BigDecimal preco);

  public Collection<Produto> findByCategoria(String categoria);

  public void update(Produto produto, Long id);

}
