package com.example.demo.core.domain.produto.useCases;

import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;

/**
 * DeleteProdutoUseCase
 */
public interface DeleteProdutoUseCase {

  public void delete(Long id) throws ProdutoNotFoundException;

}
