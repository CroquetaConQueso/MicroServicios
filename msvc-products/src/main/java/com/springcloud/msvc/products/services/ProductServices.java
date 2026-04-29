package com.springcloud.msvc.products.services;

import java.util.List;

import com.springcloud.msvc.products.dto.ProductResponse;

public interface ProductServices {
    List<ProductResponse> devolverProducts();
    ProductResponse devolverProductId(Long id);
    boolean existeId(Long id);
}
