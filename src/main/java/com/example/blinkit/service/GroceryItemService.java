package com.example.blinkit.service;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repository;

    public GroceryItemService(GroceryItemRepository repository) {
        this.repository = repository;
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public List<GroceryItem> searchItems(String keyword) {
        return repository.findByFatContentContainingIgnoreCaseOrItemIdentifierContainingIgnoreCaseOrItemTypeContainingIgnoreCase(
                keyword, keyword, keyword
        );
    }

    public void saveAll(List<GroceryItem> items) {
        repository.saveAll(items);
    }
}
