package com.example.cashregisterassignment2;

import java.util.ArrayList;
import java.util.Date;

public class Historylist extends Productlist{
    String date;
    double total;
    public Historylist(String productname, int quantity, double price, String date, double total) {
        super(productname, quantity, price);
        this.date = date;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public String toString(){
        return "[" + productname + "," + quantity + "," + price+"," + date + "," + total +  "]";
    }
}
