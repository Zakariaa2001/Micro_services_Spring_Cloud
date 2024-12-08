package com.example.billing_service.entities;

import com.example.billing_service.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;

    private int quantity;
    private double unitPrice;

    @Transient // Non persisté dans la base de données
    private Product product;

    // Constructeur sans paramètres
    public ProductItem() {
    }

    // Constructeur avec tous les paramètres
    public ProductItem(Long id, String productId, Bill bill, int quantity, double unitPrice, Product product) {
        this.id = id;
        this.productId = productId;
        this.bill = bill;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product = product;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
