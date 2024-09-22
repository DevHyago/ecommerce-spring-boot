package dev.hyago.ecommerce_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.hyago.ecommerce_spring_boot.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{};