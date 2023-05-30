package com.example.artshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clothing")
public class Clothing extends Product {

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    public Clothing() {
    }

    public Clothing(String name, String description, double price, String imageUrl, String size, String color, int quantityInStock) {
        super(name, imageUrl, price);
        this.description = description;
        this.size = size;
        this.color = color;
        this.quantityInStock = quantityInStock;
    }

    // existing getters and setters...

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}