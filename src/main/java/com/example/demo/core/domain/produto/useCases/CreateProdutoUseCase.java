package com.example.demo.core.domain.produto.useCases;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoAlredyExistsExceptoin;

/**
 * CreateProdutoUseCase
 */
public interface CreateProdutoUseCase {
  public void create(Produto produto) throws ProdutoAlredyExistsExceptoin;
}
