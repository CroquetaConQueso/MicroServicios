package com.springcloud.msvc.items.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long productId;

    @Column(name="nombre_producto", nullable = false)
    private String productName;
    
    @Column(name="precio_producto", nullable = false)
    private BigDecimal productPrice;

    @Column(name="creado_en")
    private LocalDateTime createdAt;

    @Column(name="cantidad", nullable = false)
    private int quantity;

    @Column(name="descripcion")
    private String description;

    @Column(name="codigo_producto", unique = true, nullable = false)
    private String productCode;
}
