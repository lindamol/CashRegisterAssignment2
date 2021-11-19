package com.example.cashregisterassignment2;

import android.app.Application;

public class myAPP extends Application {
    private ProductManager manager = new ProductManager();

    public ProductManager getManager() {
        return manager;
    }
}
