package com.example.demo.core.domain.produto.useCases;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;

/**
 * UpdateProdutoUseCAse
 */
public interface UpdateProdutoUseCAse {

  public void update(Produto produto, Long id) throws ProdutoNotFoundException;
}
