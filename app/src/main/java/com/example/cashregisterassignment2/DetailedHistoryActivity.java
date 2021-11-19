package com.example.cashregisterassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailedHistoryActivity extends AppCompatActivity {
     TextView detprodname;
     TextView detprice;
     TextView detdate;
     Historylist histobj;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_history);
        detprodname = findViewById(R.id.detprodname);
        detprice = findViewById(R.id.detprice);
        detdate = findViewById(R.id.detdate);
        Intent fromhistoryintent = getIntent();
       histobj = this.getIntent().getParcelableExtra("dethistory");
       //System.out.println("My product name is :"+ histobj.getProductname());
            detprodname.setText("Product :"+histobj.getProductname());
            detprice.setText("Price :"+histobj.getTotal());
            detdate.setText("Purchase Date: " +histobj.getDate());

    }
}