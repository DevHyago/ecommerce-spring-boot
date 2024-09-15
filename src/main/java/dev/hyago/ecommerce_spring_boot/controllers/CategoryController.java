package dev.hyago.ecommerce_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.hyago.ecommerce_spring_boot.domain.Category;
import dev.hyago.ecommerce_spring_boot.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  public ResponseEntity<?> find(@PathVariable Integer id){
    Category category = this.categoryService.find(id);
    if(category == null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok().body(category);
  }

}
