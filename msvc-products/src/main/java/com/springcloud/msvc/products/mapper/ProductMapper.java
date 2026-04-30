package com.springcloud.msvc.products.mapper;

import org.springframework.stereotype.Component;

import com.springcloud.msvc.products.dto.ProductRequest;
import com.springcloud.msvc.products.dto.ProductResponse;
import com.springcloud.msvc.products.models.Product;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest pDto){
        return Product.builder().productName(pDto.productName())
        .quantity(pDto.quantity()).build();
    }

    public ProductResponse toResponse(Product product, String port){
        return new ProductResponse(product.getProductId(),product.getProductName(),
                    product.getProductPrice(),product.getCreatedAt(),product.getQuantity()
                    ,product.getDescription(),product.getProductCode(), port);
    }
}
