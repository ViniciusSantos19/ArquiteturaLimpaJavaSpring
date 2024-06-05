package com.example.demo.core.domain.produto.useCases;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;

/**
 * ConsultarProdutosUse
 */
public interface ConsultarProdutosUseCase {

  public Optional<Produto> findProdutoById(Long id) throws ProdutoNotFoundException;

  public Collection<Produto> getAllProdutos();

  public Collection<Produto> findProdutosByNome(String nome) throws ProdutoNotFoundException;

  public Collection<Produto> findProdutoByPreco(BigDecimal preco) throws ProdutoNotFoundException;

  public Collection<Produto> findByCategoria(String categoria) throws ProdutoNotFoundException;

}
