package com.example.demo.core.domain.usuario;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Min(0)
  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  private String email;
  @NotBlank
  private String password;

}
