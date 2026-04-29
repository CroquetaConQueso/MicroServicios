package com.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springcloud.msvc.items.clients.ProductFeignClient;
import com.springcloud.msvc.items.dto.ProductResponse;
import com.springcloud.msvc.items.models.Lote;

@Service
public class LoteServiceFeign implements LoteService {

    private ProductFeignClient productFeignClient;

    public LoteServiceFeign(ProductFeignClient productFeignClient){
        this.productFeignClient = productFeignClient;
    }
    @Override
    public List<Lote> findAll() {
        return productFeignClient.findAll().stream().map(product -> {
            return new Lote(product , UUID.randomUUID().toString(), "wewe");
        }).toList();
    }

    @Override
    public Optional<Lote> findById(Long id) {
        ProductResponse product = productFeignClient.obtenerProducto(id);
        Lote lote = new Lote(product, UUID.randomUUID().toString(), "Pepito");
        return Optional.of(lote);
    }
    
}
