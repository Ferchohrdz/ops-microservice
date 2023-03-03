package com.hernandez.springboot.backend.springbootbackendapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record BaseClienteResponse<T>(String message, T data) {
}
