package com.springcloud.msvc.products.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.msvc.products.dto.ProductResponse;
import com.springcloud.msvc.products.services.ProductServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name= "Productos", description="Productos de una empresa")
@RequestMapping("/productos")
public class ProductController {
    
    private final ProductServices productoServices;

    public ProductController(ProductServices productServices){
        this.productoServices = productServices;
    }

    @GetMapping
    @ApiResponses({
        @ApiResponse(responseCode = "200", description="Productos obtenidos"),
        @ApiResponse(responseCode = "401", description="Token ausente")
    })
    @Operation(summary= "Lista productos", description="Lista todos los productos")
    public ResponseEntity<List<ProductResponse>> obtenerProductos() {
        return ResponseEntity.ok(productoServices.devolverProducts());
    }

    @GetMapping("/{id}")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description="Productos obtenidos"),
        @ApiResponse(responseCode = "400", description="ID invalido"),
        @ApiResponse(responseCode = "401", description="Token ausente"),
        @ApiResponse(responseCode = "404", description= "Producto no encontrado")
    })
    @Operation(summary= "Obtener un producto", description="Obtiene un producto por su id")
    public ResponseEntity<ProductResponse> obtenerProducto(@PathVariable Long id) {

        return ResponseEntity.ok(productoServices.devolverProductId(id));
    }
    
    
}
