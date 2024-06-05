package com.example.demo.infrastructure.delivery.responses;

import java.io.Serializable;

import lombok.Data;

/**
 * ProjectResponse
 */
@Data
public class ProjectResponse<T> implements Serializable {
  private String status;
  private String code;
  private String message;
  private T data;

  public ProjectResponse(String status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public ProjectResponse(String status, String code, String message, T data) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.data = data;
  }

}
