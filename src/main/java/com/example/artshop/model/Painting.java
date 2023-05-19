package com.example.artshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paintings")
public class Painting extends Product {

    private String artist;
    private double width;
    private double height;
    private int yearCreated;

    public Painting() {
    }

    public Painting(String title, String artist, double width, double height, String imageURL, double price, int yearCreated) {
        super(title, imageURL, price);
        this.artist = artist;
        this.width = width;
        this.height = height;
        this.yearCreated = yearCreated;
    }

    // Getters and setters

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }
}
// Этот класс представляет сущность Painting, которая будет сохраняться в базе данных.
// Класс содержит основные атрибуты картины, такие как название, художник, ширина,
// высота и URL-адрес изображения. Также в классе определены геттеры и сеттеры для каждого атрибута.
// Класс аннотирован с @Entity, чтобы указать, что он представляет сущность базы данных,
// а поле id аннотировано с @Id и @GeneratedValue, чтобы указать, что это первичный ключ и будет генерироваться
// автоматически.
