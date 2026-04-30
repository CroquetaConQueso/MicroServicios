package com.springcloud.msvc.products.services;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springcloud.msvc.products.dto.ProductResponse;
import com.springcloud.msvc.products.mapper.ProductMapper;
import com.springcloud.msvc.products.repositories.ProductRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServicesImp implements ProductServices {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Environment environment;

    public ProductServicesImp(ProductRepository productRepository, ProductMapper productMapper, Environment environment){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.environment = environment;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponse> devolverProducts(){
        return productRepository.findAll().stream().map(product -> productMapper.toResponse(product,environment.getProperty(("local.server.port")))).toList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public ProductResponse devolverProductId(Long id){
        return productMapper.toResponse(productRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado")),
        environment.getProperty("local.server.port"));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existeId(Long id){
        return productRepository.existsById(id);
    }
    
}
