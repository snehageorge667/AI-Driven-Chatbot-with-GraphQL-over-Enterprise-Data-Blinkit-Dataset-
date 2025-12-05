package com.example.blinkit.controller;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.service.GroceryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class GroceryItemController {

    private final GroceryItemService service;

    public GroceryItemController(GroceryItemService service) {
        this.service = service;
    }

    // GET full list (default 100)
    @GetMapping
    public List<GroceryItem> getAll(@RequestParam(defaultValue = "100") int limit) {
        return service.getLimitedItems(limit);
    }

    // GET with explicit limit
    @GetMapping("/limit")
    public List<GroceryItem> getLimited(@RequestParam(defaultValue = "10") int limit) {
        return service.getLimitedItems(limit);
    }

    // Search endpoint for free API
    @GetMapping("/search")
    public List<GroceryItem> search(@RequestParam String keyword,
                                    @RequestParam(defaultValue = "20") int limit) {
        return service.search(keyword, limit);
    }
}
