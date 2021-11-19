package com.example.cashregisterassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {
    Button buttonHistory;
    Button buttonRestock;
    ArrayList<Historylist> myhistoryarray = new ArrayList<>();

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_manager);
        Intent frommainintent = getIntent();
        buttonHistory = findViewById(R.id.history);
        buttonRestock = findViewById(R.id.restock);
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(frommainintent.getExtras().getParcelableArrayList("history")).isEmpty())
                {    myhistoryarray = frommainintent.getExtras().getParcelableArrayList("history");
                   // myhistoryarray = this.getIntent().getExtras().getParcelableArrayList("history");
                }
                else {System.out.println("Empty History");
                                    }
//                System.out.println("Printing History in ManagerPanel:");
//                System.out.println(myhistoryarray);
                openHistoryActivity();
            }
        });
        buttonRestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                           openRestockActivity();
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
    private void openRestockActivity(){
            Intent intent = new Intent(this,RestockActivity.class);
            startActivity(intent);
    }
}