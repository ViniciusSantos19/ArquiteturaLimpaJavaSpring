package com.example.demo.infrastructure.shared.exception;

import org.springframework.http.HttpStatus;

/**
 * BadRequestException
 */
public class BadRequestException extends ProjectException {

  private static final long serialVersionUID = -5330068136795055851L;

  public BadRequestException(String message) {
    super(HttpStatus.BAD_REQUEST.value(), message);
  }
}
