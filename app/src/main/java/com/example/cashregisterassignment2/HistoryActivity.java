package com.example.cashregisterassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
 RecyclerView historyRecyclerview;
 ArrayList<Historylist> myhistorylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent frommangerintent = getIntent();
        historyRecyclerview = findViewById(R.id.historyRecyclerview);
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        if(!(this.getIntent().getExtras().getParcelableArrayList("forhistroryActivity") == null))
        {
            myhistorylist = this.getIntent().getExtras().getParcelableArrayList("forhistroryActivity");
            System.out.println(myhistorylist);
            HistoryAdapter adapter = new HistoryAdapter(this, myhistorylist);
            historyRecyclerview.setAdapter(adapter);
        }
        else {System.out.println("Empty History");}
//        System.out.println("Printing History in HistoryActivity:");
//
    }
}