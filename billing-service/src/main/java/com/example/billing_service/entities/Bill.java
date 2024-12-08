package com.example.billing_service.entities;

import com.example.billing_service.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerId;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();

    @Transient
    private Customer customer;

    // Constructeur sans paramètres
    public Bill() {
    }

    // Constructeur avec tous les paramètres
    public Bill(Long id, Date billingDate, long customerId, List<ProductItem> productItems, Customer customer) {
        this.id = id;
        this.billingDate = billingDate;
        this.customerId = customerId;
        this.productItems = productItems;
        this.customer = customer;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
