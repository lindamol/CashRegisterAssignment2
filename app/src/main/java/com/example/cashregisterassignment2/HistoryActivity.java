package com.example.cashregisterassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
 RecyclerView historyRecyclerview;
 TextView historytextview;
 ArrayList<Historylist> myhistorylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent frommangerintent = getIntent();
        historytextview = findViewById(R.id.historytextView);
        historytextview.setVisibility(View.INVISIBLE);
        historyRecyclerview = findViewById(R.id.historyRecyclerview);
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        if(!(this.getIntent().getExtras().getParcelableArrayList("forhistroryActivity").isEmpty()))
        {
            myhistorylist = this.getIntent().getExtras().getParcelableArrayList("forhistroryActivity");
            //System.out.println(myhistorylist);
            HistoryAdapter adapter = new HistoryAdapter(this, myhistorylist);
            historyRecyclerview.setAdapter(adapter);
        }
        else {System.out.println("Empty History");
           historytextview.setText("NO PURCHASE HISTORY");
           historytextview.setVisibility(View.VISIBLE);
           historyRecyclerview.setVisibility(View.INVISIBLE);
        }
//        System.out.println("Printing History in HistoryActivity:");
//
    }
}