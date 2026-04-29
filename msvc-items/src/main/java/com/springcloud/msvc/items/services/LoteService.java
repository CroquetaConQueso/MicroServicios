package com.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import com.springcloud.msvc.items.models.Lote;

public interface LoteService {
    List<Lote> findAll();
    Optional<Lote> findById(Long id);
}
