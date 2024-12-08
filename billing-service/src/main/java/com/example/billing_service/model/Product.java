package com.example.billing_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    // Getter pour id
    public String getId() {
        return id;
    }

    // Setter pour id
    public void setId(String id) {
        this.id = id;
    }

    // Getter pour name
    public String getName() {
        return name;
    }

    // Setter pour name
    public void setName(String name) {
        this.name = name;
    }

    // Getter pour price
    public double getPrice() {
        return price;
    }

    // Setter pour price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter pour quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter pour quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

