package com.example.blinkit.repository;

import com.example.blinkit.entity.GroceryItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    @Query("""
            SELECT g FROM GroceryItem g
            WHERE LOWER(g.fatContent) LIKE %:keyword%
               OR LOWER(g.itemIdentifier) LIKE %:keyword%
               OR LOWER(g.itemType) LIKE %:keyword%
            """)
    List<GroceryItem> search(String keyword, Pageable page);
}
