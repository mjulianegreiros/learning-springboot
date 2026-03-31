package com.example.catalog.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    public Product(){}
    public Product(String name , Double price){
        this.name = name;
        this.price = price;
    }

    public Long getId(){ return this.id; }
    public String getName(){ return this.name; }
    public Double getPrice(){ return this.price; }

    public void setName(String name){ this.name = name; }
    public void setPrice(Double price){ this.price = price; }
}
