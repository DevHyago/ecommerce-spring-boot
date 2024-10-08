package dev.hyago.ecommerce_spring_boot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String name;

  @ManyToMany(mappedBy="categories")
  private List<Product> products = new ArrayList<>();

  public Category(){}

  public Category(Integer id, String name){
    this.id = id;
    this.name = name;
  }

  public Integer getId(){
    return this.id;
  }

  public void setId(Integer id){
    this.id = id;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public void setProducts(List<Product> products) {
      this.products = products;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null) return false;
    if(this.getClass() != obj.getClass()) return false;
    Category other = (Category) obj;
    if(this.id == null){
      if(other.id != null) return false;
    }else if(!this.id.equals(other.id)) {
      return false;
    }
    return true;
  }

}
