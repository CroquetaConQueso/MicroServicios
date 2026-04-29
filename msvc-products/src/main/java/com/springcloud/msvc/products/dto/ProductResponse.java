package com.springcloud.msvc.products.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record ProductResponse(
    Long id, String productName, BigDecimal productPrice,
    LocalDateTime createdAt, int quantity, String description,
    String productCode
) {}
