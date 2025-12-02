package com.example.blinkit.controller;

import com.example.blinkit.entity.GroceryItem;
import com.example.blinkit.service.CSVService;
import com.example.blinkit.service.GroceryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    private final GroceryItemService service;
    private final CSVService csvService;

    public GroceryController(GroceryItemService service, CSVService csvService) {
        this.service = service;
        this.csvService = csvService;
    }

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/type/{type}")
    public List<GroceryItem> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/fat/{fat}")
    public List<GroceryItem> getByFatContent(@PathVariable String fat) {
        return service.getByFatContent(fat);
    }

    @GetMapping("/outlet/{id}")
    public List<GroceryItem> getByOutlet(@PathVariable String id) {
        return service.getByOutlet(id);
    }

    @PostMapping("/load-csv")
    public String loadData() {
        List<GroceryItem> items = csvService.loadCSV();
        items.forEach(service::save);
        return "CSV data loaded successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted ID: " + id;
    }
}
