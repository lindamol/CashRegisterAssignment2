package com.example.cashregisterassignment2;

import android.app.Application;

import java.util.ArrayList;

public class myAPP extends Application {
    private ProductManager manager = new ProductManager();
    //private ArrayList<Productlist> productArray = new ArrayList<>();

//    public ArrayList<Productlist> getProductArray() {
//        return productArray;
//    }


    public ProductManager getManager() {
        return manager;
    }
}
