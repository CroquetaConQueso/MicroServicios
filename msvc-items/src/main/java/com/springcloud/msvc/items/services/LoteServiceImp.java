package com.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springcloud.msvc.items.models.Lote;
import com.springcloud.msvc.items.repositories.LoteRepository;

@Service
public class LoteServiceImp implements LoteService {

    private LoteRepository loteRepository;

    public LoteServiceImp(LoteRepository loteRepository){
        this.loteRepository = loteRepository;
    }
    @Override
    public List<Lote> findAll() {
        return loteRepository.findAll();
    }

    @Override
    public Optional<Lote> findById(Long id) {
        return loteRepository.findById(id);
    }
    
}
