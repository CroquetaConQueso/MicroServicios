package com.springcloud.msvc.items.models;

import java.math.BigDecimal;

import com.springcloud.msvc.items.dto.ProductResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lote {
    private ProductResponse product;
    private String codigoLote;
    private String destinatario;

    public BigDecimal getTotal(){
        return product.productPrice().multiply(BigDecimal.valueOf(product.quantity()));
    }


}
