package com.example.demo.core.domain.produto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.demo.core.domain.produto.enums.Categoria;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Produto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {

  private static final long serialVersionUID = 1L;

  @Min(0)
  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  private String descricao;
  @NotBlank
  private BigDecimal preco;
  @NotBlank
  private int quantidadeEstoque;
  @NotBlank
  private Categoria categoria;
}
