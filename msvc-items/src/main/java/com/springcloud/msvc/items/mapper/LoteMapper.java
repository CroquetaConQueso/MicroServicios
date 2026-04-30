package com.springcloud.msvc.items.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.springcloud.msvc.items.dto.LoteResponse;
import com.springcloud.msvc.items.dto.ProductResponse;

@Component
public class LoteMapper {

    public LoteResponse toLoteResponse(ProductResponse product,String codigoLote,String destinatario) {

        BigDecimal total = product.productPrice().multiply(BigDecimal.valueOf(product.quantity()));

        return new LoteResponse(product,codigoLote,destinatario,total);
    }
}