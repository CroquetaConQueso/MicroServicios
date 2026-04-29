package com.springcloud.msvc.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springcloud.msvc.products.dto.ProductResponse;
import com.springcloud.msvc.products.mapper.ProductMapper;
import com.springcloud.msvc.products.repositories.ProductRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServicesImp implements ProductServices {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServicesImp(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponse> devolverProducts(){
        return productRepository.findAll().stream().map(productMapper::toResponse).toList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public ProductResponse devolverProductId(Long id){
        return productMapper.toResponse(productRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado")));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existeId(Long id){
        return productRepository.existsById(id);
    }
    
}
