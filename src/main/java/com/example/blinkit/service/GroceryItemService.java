package com.example.blinkit.service;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.repository.GroceryItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repo;

    public GroceryItemService(GroceryItemRepository repo) {
        this.repo = repo;
    }

    public long countItems() {
        return repo.count();
    }

    public void saveAll(List<GroceryItem> items) {
        repo.saveAll(items);
    }

    public List<GroceryItem> getLimitedItems(int limit) {
        Pageable page = PageRequest.of(0, limit);
        return repo.findAll(page).getContent();
    }

    public List<GroceryItem> search(String keyword, int limit) {
        Pageable page = PageRequest.of(0, limit);
        return repo.search(keyword.toLowerCase(), page);
    }
}
