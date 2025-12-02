package com.example.blinkit.service;

import com.example.blinkit.entity.GroceryItem;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    public List<GroceryItem> loadCSV() {
        List<GroceryItem> items = new ArrayList<>();

        try {
            ClassPathResource resource = new ClassPathResource("BlinkIT-Grocery-Data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            reader.readLine(); // skip header

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                GroceryItem item = new GroceryItem();
                item.setItemFatContent(data[0]);
                item.setItemIdentifier(data[1]);
                item.setItemType(data[2]);
                item.setOutletEstablishmentYear(Integer.parseInt(data[3]));
                item.setOutletIdentifier(data[4]);
                item.setOutletLocationType(data[5]);
                item.setOutletSize(data[6]);
                item.setOutletType(data[7]);
                item.setItemVisibility(Double.parseDouble(data[8]));
                item.setItemWeight(Double.parseDouble(data[9]));
                item.setSales(Double.parseDouble(data[10]));
                item.setRating(Double.parseDouble(data[11]));

                items.add(item);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }
}
