package dev.hyago.ecommerce_spring_boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.hyago.ecommerce_spring_boot.domain.Category;
import dev.hyago.ecommerce_spring_boot.repositories.CategoryRepository;

@SpringBootApplication
public class EcommerceSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<String> categories = new ArrayList<>(Arrays.asList("Informática", "Escritório"));
		for(int i = 0; i < categories.size(); i++){
			Optional<Category> categoryExists = this.categoryRepository.findById(i + 1);
			if(categoryExists.isEmpty()){
				Category category = new Category(i + 1, categories.get(i));
				categoryRepository.save(category);
			}
		}
	}

}
