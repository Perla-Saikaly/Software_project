package com.example.software_project;

public class NewPhone {
    private String name, status;
    private int price, quantity;

    public NewPhone(String name, String staus, int price, int quantity) {
       this.name=name;
       this.status=staus;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NewPhone\n" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", quantity=" + quantity ;
    }
}
