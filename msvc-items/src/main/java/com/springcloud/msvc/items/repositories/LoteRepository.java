package com.springcloud.msvc.items.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.msvc.items.models.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote,Long>{
    
}
