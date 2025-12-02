package com.example.blinkit.service;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.repository.GroceryItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repo;
    private static final Logger log = LoggerFactory.getLogger(GroceryItemService.class);

    public GroceryItemService(GroceryItemRepository repo) {
        this.repo = repo;
    }

    public List<GroceryItem> getAll() {
        log.info("Fetching all grocery items");
        return repo.findAll();
    }

    public GroceryItem save(GroceryItem item) {
        log.info("Saving item: {}", item.getItemIdentifier());
        return repo.save(item);
    }

    public void delete(Long id) {
        log.warn("Deleting item with ID: {}", id);
        repo.deleteById(id);
    }

    public List<GroceryItem> getByType(String type) {
        return repo.findByItemType(type);
    }

    public List<GroceryItem> getByFatContent(String fat) {
        return repo.findByItemFatContent(fat);
    }

    public List<GroceryItem> getByOutlet(String outletId) {
        return repo.findByOutletIdentifier(outletId);
    }
}
