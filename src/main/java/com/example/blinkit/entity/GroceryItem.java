package com.example.blinkit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grocery_items")
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fatContent;
    private String itemIdentifier;
    private String itemType;
    private Integer outletYear;

    // ✅ CHANGED: sales → price
    private Double price;

    public GroceryItem() {}

    public GroceryItem(
            String fatContent,
            String itemIdentifier,
            String itemType,
            Integer outletYear,
            Double price
    ) {
        this.fatContent = fatContent;
        this.itemIdentifier = itemIdentifier;
        this.itemType = itemType;
        this.outletYear = outletYear;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getFatContent() {
        return fatContent;
    }

    public void setFatContent(String fatContent) {
        this.fatContent = fatContent;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getOutletYear() {
        return outletYear;
    }

    public void setOutletYear(Integer outletYear) {
        this.outletYear = outletYear;
    }

    // ✅ REQUIRED by your service
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
