package com.example.blinkit.service;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.repository.GroceryItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repo;

    public GroceryItemService(GroceryItemRepository repo) {
        this.repo = repo;
    }

    public String searchFromDataset(String message) {

        List<GroceryItem> results =
                repo.search(message.toLowerCase(), PageRequest.of(0, 1));

        if (results.isEmpty()) {
            return null;
        }

        GroceryItem item = results.get(0);

        // Dataset does NOT contain price → do not fabricate it
        return "Item ID: " + item.getItemIdentifier()
                + "\nType: " + item.getItemType()
                + "\nFat Content: " + item.getFatContent();
    }

    public long countItems() {
        return repo.count();
    }

    public void saveAll(List<GroceryItem> items) {
        repo.saveAll(items);
    }
}
