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

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAllItems();
    }

    @GetMapping("/search")
    public List<GroceryItem> search(@RequestParam String keyword) {
        return service.searchItems(keyword);
    }
}
