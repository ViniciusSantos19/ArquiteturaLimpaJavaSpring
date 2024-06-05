package com.example.demo.infrastructure.delivery.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.demo.core.domain.produto.enums.Categoria;

/**
 * ProdutoDto
 */
public record ProdutoDto(String nome,
    String descricao,
    BigDecimal preco,
    int quantidadeEstoque,
    Categoria categoria) implements Serializable {
}
