package dev.hyago.ecommerce_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.hyago.ecommerce_spring_boot.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{}
