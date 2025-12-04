package com.example.blinkit.repository;

import com.example.blinkit.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    // Free search across fatContent, itemIdentifier, itemType
    List<GroceryItem> findByFatContentContainingIgnoreCaseOrItemIdentifierContainingIgnoreCaseOrItemTypeContainingIgnoreCase(
            String fatContent, String itemIdentifier, String itemType);
}
