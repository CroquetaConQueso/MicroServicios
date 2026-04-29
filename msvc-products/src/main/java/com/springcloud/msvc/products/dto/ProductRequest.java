package com.springcloud.msvc.products.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(@NotBlank( message = "El producto debe de tener un nombre")
    @Size(max = 50, message = "El nombre del producto no puede superar los 50 caracteres")
    String productName,
    @NotNull(message="La cantidad es obligatoria")
    @Min(value= 0, message="La cantidad no puede ser negativa")
    Integer quantity) {
}
