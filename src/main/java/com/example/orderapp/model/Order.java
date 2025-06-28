package com.example.orderapp.model;

public class Order {

    private Long id;
    private String productName;
    private String status; // e.g. "PENDING", "ACCEPTED"

    public Order() {}

    public Order(Long id, String productName, String status) {
        this.id = id;
        this.productName = productName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
