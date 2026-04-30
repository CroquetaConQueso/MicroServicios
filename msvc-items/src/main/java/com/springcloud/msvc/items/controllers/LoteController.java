package com.springcloud.msvc.items.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.msvc.items.dto.LoteResponse;
import com.springcloud.msvc.items.services.LoteService;

@RequestMapping("/lotes")
@RestController
public class LoteController {
    private final LoteService loteService;

    public LoteController(LoteService loteService){
        this.loteService = loteService;
    }

    @GetMapping
    public ResponseEntity<List<LoteResponse>> obtenerLotes(){
        return ResponseEntity.ok(loteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoteResponse> obtenerLote(@PathVariable Long id){
        return loteService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
