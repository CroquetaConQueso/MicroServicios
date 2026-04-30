package com.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springcloud.msvc.items.clients.ProductFeignClient;
import com.springcloud.msvc.items.dto.LoteResponse;
import com.springcloud.msvc.items.dto.ProductResponse;
import com.springcloud.msvc.items.mapper.LoteMapper;

@Service
public class LoteServiceFeign implements LoteService {

    private ProductFeignClient productFeignClient;
    private LoteMapper loteMapper;

    public LoteServiceFeign(ProductFeignClient productFeignClient, LoteMapper loteMapper){
        this.productFeignClient = productFeignClient;
        this.loteMapper = loteMapper;
    }

    @Override
    public List<LoteResponse> findAll() {
        return productFeignClient.findAll().stream().map(product -> loteMapper.toLoteResponse(product, UUID.randomUUID().toString(), "Cliente demo")).toList();
    }

    @Override
    public Optional<LoteResponse> findById(Long id) {
        ProductResponse product = productFeignClient.obtenerProducto(id);
        LoteResponse lote = loteMapper.toLoteResponse(product, UUID.randomUUID().toString(), "Pepito");
        return Optional.of(lote);
    }


    
}
