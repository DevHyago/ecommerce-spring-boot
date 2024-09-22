package dev.hyago.ecommerce_spring_boot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity()
public class Product implements Serializable{

  private static final long serialVersionUID = 1l;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Double price;

  @ManyToMany
  @JoinTable(
    name = "PRODUCT_CATEGORY",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private List<Category> categories = new ArrayList<>();

  public Product(){}

  public Product(Integer id, String name, Double price){
    this.id = id;
    this.name = name;
    this.price = price;
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

  public Double getPrice(){
    return this.price;
  }

  public void setPrice(Double price){
    this.price = price;
  }

  public List<Category> getCategories() {
    return this.categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
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
    Product other = (Product) obj;
    if(this.id == null){
      if(other.id != null) return false;
    }else if(!this.id.equals(other.id)) {
      return false;
    }
    return true;
  }
}
