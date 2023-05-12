package com.example.artshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Painting painting;
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private LocalDateTime orderDate;
    private double totalPrice;

    public Order() {
    }

    public Order(Painting painting, String customerName, String customerEmail, String shippingAddress, LocalDateTime orderDate, double totalPrice) {
        this.painting = painting;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Painting getPainting() {
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
// Этот класс представляет сущность Order, которая будет сохраняться в базе данных.
// Класс содержит основные атрибуты заказа, такие как ссылка на картину, имя клиента,
// адрес электронной почты клиента, адрес доставки, дата заказа и общая стоимость.
// Также в классе определены геттеры и сеттеры для каждого атрибута. Класс аннотирован с @Entity,
// чтобы указать, что он представляет сущность базы данных, а поле id аннотировано с @Id и @GeneratedValue,
// чтобы указать, что это первичный ключ и будет генерироваться автоматически.
