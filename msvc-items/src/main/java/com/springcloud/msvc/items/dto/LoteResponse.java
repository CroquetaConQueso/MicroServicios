package com.springcloud.msvc.items.dto;

import java.math.BigDecimal;

public record LoteResponse( ProductResponse product, String codigoLote, String destinatario, BigDecimal total) {
    
}
