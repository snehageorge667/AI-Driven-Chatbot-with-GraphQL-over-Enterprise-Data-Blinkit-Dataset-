package com.example.blinkit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemFatContent;
    private String itemIdentifier;
    private String itemType;
    private Integer outletEstablishmentYear;
    private String outletIdentifier;
    private String outletLocationType;
    private String outletSize;
    private String outletType;

    private Double itemVisibility;
    private Double itemWeight;
    private Double sales;
    private Double rating;
}
