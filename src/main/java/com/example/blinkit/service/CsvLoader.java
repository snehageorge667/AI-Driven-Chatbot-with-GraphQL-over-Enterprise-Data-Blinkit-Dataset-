package com.example.blinkit.service;

import com.example.blinkit.entity.Product;
import com.example.blinkit.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class CsvLoader implements CommandLineRunner {

    private final ProductRepository repository;

    public CsvLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        // HR demo: always start clean
        repository.deleteAll();

        List<String> lines =
                Files.readAllLines(Paths.get("src/main/resources/blinkit_products.csv"));

        lines.stream().skip(1).forEach(line -> {
            try {
                String[] data = line.replace("\"", "").split(",");

                Product p = new Product();
                p.setProductName(data[1].trim());          // Item Identifier
                p.setCategory(data[2].trim());             // Item Type
                p.setPrice(Double.parseDouble(data[10]));  // Sales
                p.setRating(Double.parseDouble(data[11])); // Rating

                repository.save(p);

            } catch (Exception e) {
                // Skip only truly bad rows
                System.out.println("Skipped row: " + line);
            }
        });

        System.out.println("CSV LOAD COMPLETE");
    }
}
