package com.springcloud.msvc.products.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.msvc.products.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    Optional<Product>findById(Long id);
    boolean existsById(Long id);
}
