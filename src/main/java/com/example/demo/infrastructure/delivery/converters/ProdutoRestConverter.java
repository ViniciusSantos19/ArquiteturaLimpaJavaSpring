package com.example.demo.infrastructure.delivery.converters;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.infrastructure.delivery.dtos.ProdutoDto;
import com.example.demo.infrastructure.shared.RestConverter;

/**
 * ProdutoRestConverter
 */
public class ProdutoRestConverter implements RestConverter<ProdutoDto, Produto> {
  @Override
  public Produto mapToEntity(ProdutoDto rest) {
    return new Produto(null, rest.nome(), rest.descricao(),
        rest.preco(),
        rest.quantidadeEstoque(),
        rest.categoria());
  }

  @Override
  public ProdutoDto mapRoRest(Produto entiry) {
    return new ProdutoDto(entiry.getNome(),
        entiry.getDescricao(),
        entiry.getPreco(),
        entiry.getQuantidadeEstoque(),
        entiry.getCategoria());
  }
}
