package com.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import com.springcloud.msvc.items.dto.LoteResponse;

public interface LoteService {
    List<LoteResponse> findAll();
    Optional<LoteResponse> findById(Long id);
}
