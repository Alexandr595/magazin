package com.example.artshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private double width;
    private double height;
    private String imageURL;
    private double price;
    private int yearCreated;

    public Painting() {
    }

    public Painting(String title, String artist, double width, double height, String imageURL, double price, int yearCreated) {
        this.title = title;
        this.artist = artist;
        this.width = width;
        this.height = height;
        this.imageURL = imageURL;
        this.price = price;
        this.yearCreated = yearCreated;
    }

    // existing getters and setters...

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
// Этот класс представляет сущность Painting, которая будет сохраняться в базе данных.
// Класс содержит основные атрибуты картины, такие как название, художник, ширина,
// высота и URL-адрес изображения. Также в классе определены геттеры и сеттеры для каждого атрибута.
// Класс аннотирован с @Entity, чтобы указать, что он представляет сущность базы данных,
// а поле id аннотировано с @Id и @GeneratedValue, чтобы указать, что это первичный ключ и будет генерироваться
// автоматически.
