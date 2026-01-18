package com.example.blinkit.graphql;

import com.example.blinkit.entity.Product;
import com.example.blinkit.repository.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductQuery {

    private final ProductRepository repository;

    public ProductQuery(ProductRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public List<Product> productsByCategory(@Argument String category) {
        return repository.findByCategory(category);
    }
}
