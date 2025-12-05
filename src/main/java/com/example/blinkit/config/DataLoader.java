package com.example.blinkit.config;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.service.GroceryItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final GroceryItemService service;

    public DataLoader(GroceryItemService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

        // Avoid duplicate loading
        if (service.countItems() > 0) {
            System.out.println("Data already loaded. Skipping CSV import.");
            return;
        }

        List<GroceryItem> items = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new ClassPathResource("blinkit_products.csv").getInputStream(),
                StandardCharsets.UTF_8
        ));

        String line;
        boolean firstLine = true;

        while ((line = br.readLine()) != null) {

            if (firstLine) { 
                firstLine = false; 
                continue; 
            }

            String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            String fatContent = clean(parts[0]);
            String itemIdentifier = clean(parts[1]);
            String itemType = clean(parts[2]);
            Integer outletYear = parseInt(parts[3]);
            Double sales = parseDouble(parts[10]);

            GroceryItem item = new GroceryItem(
                    fatContent,
                    itemIdentifier,
                    itemType,
                    outletYear,
                    sales
            );

            items.add(item);
        }

        service.saveAll(items);

        System.out.println("CSV Imported → " + items.size() + " grocery items loaded into PostgreSQL.");
    }

    private String clean(String s) {
        return s.replace("\"", "").trim();
    }

    private Integer parseInt(String s) {
        try {
            return Integer.parseInt(clean(s));
        } catch (Exception e) {
            return null;
        }
    }

    private Double parseDouble(String s) {
        try {
            return Double.parseDouble(clean(s));
        } catch (Exception e) {
            return null;
        }
    }
}
