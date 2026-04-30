package com.springcloud.msvc.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcloud.msvc.items.dto.ProductResponse;

//La url no se debe de establecer si esta definida en el properties: url = "http://localhost:8001/productos"
@FeignClient(name = "msvc-products", path = "/productos")
public interface ProductFeignClient {
    
    @GetMapping()
    List<ProductResponse> findAll();

    @GetMapping("/{id}")
    ProductResponse obtenerProducto(@PathVariable Long id);

}
