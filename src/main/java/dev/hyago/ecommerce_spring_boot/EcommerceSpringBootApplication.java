package dev.hyago.ecommerce_spring_boot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.hyago.ecommerce_spring_boot.domain.Category;
import dev.hyago.ecommerce_spring_boot.domain.Product;
import dev.hyago.ecommerce_spring_boot.repositories.CategoryRepository;
import dev.hyago.ecommerce_spring_boot.repositories.ProductRepository;

@SpringBootApplication
public class EcommerceSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Categories
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		// Products
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		//Add product into category
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		//Add category in the product
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));


		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		this.productRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
