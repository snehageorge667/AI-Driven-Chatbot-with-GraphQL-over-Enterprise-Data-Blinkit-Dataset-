package com.example.blinkit.repository;

import com.example.blinkit.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    List<GroceryItem> findByItemType(String itemType);

    List<GroceryItem> findByOutletIdentifier(String outletIdentifier);

    List<GroceryItem> findByItemFatContent(String itemFatContent);
}
