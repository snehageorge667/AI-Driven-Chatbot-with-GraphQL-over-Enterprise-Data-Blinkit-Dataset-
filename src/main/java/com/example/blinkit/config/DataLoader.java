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
        List<GroceryItem> items = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new ClassPathResource("blinkit_products.csv").getInputStream(), StandardCharsets.UTF_8));

        String line;
        boolean firstLine = true;
        while ((line = br.readLine()) != null) {
            if (firstLine) { firstLine = false; continue; } // skip header

            String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // split CSV correctly

            String fatContent = parts[0].replace("\"", "").trim();
            String itemIdentifier = parts[1].replace("\"", "").trim();
            String itemType = parts[2].replace("\"", "").trim();
            Integer outletYear = safeInt(parts, 3);
            Double sales = safeDouble(parts, 10);

            items.add(new GroceryItem(fatContent, itemIdentifier, itemType, outletYear, sales));
        }

        service.saveAll(items);
        System.out.println("Loaded " + items.size() + " items.");
    }

    private Integer safeInt(String[] parts, int index) {
        try { return Integer.parseInt(parts[index].replace("\"", "").trim()); }
        catch (Exception e) { return null; }
    }

    private Double safeDouble(String[] parts, int index) {
        try { return Double.parseDouble(parts[index].replace("\"", "").trim()); }
        catch (Exception e) { return null; }
    }
}
