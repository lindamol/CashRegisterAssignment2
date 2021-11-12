package com.example.cashregisterassignment2;

public class Productlist {
    String productname;
    int quantity;
    double price;

    public Productlist(String productname, int quantity, double price) {
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return "[" + productname + "," + quantity + "," + price+ "]";
    }
}
