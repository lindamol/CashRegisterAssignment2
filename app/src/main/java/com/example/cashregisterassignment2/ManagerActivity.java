package com.example.cashregisterassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {
    Button buttonHistory;
    ArrayList<Historylist> myhistoryarray = new ArrayList<>();
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_manager);
        Intent frommainintent = getIntent();
       if(!(this.getIntent().getExtras().getParcelableArrayList("history") == null))
       {
           myhistoryarray = this.getIntent().getExtras().getParcelableArrayList("history");
       }
       else {System.out.println("Empty History");}
        System.out.println("Printing History in ManagerPanel:");
        System.out.println(myhistoryarray);
        buttonHistory = findViewById(R.id.history);
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistoryActivity();
            }
        });
            }

    private void openHistoryActivity() {
        Intent historyintent = new Intent(this,HistoryActivity.class);
        Bundle bundlehistory = new Bundle();
        bundlehistory.putParcelableArrayList("forhistroryActivity",myhistoryarray);
        historyintent.putExtras(bundlehistory);
        startActivity(historyintent);
    }
}