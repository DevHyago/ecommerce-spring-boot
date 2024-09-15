package dev.hyago.ecommerce_spring_boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.hyago.ecommerce_spring_boot.domain.Category;
import dev.hyago.ecommerce_spring_boot.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category find(Integer id){
    Optional<Category> category = this.categoryRepository.findById(id);
    return category.orElse(null);
  }
}
