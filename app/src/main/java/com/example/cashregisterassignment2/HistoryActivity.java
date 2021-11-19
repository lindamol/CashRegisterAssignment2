package com.example.cashregisterassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.listClickListener{
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
            adapter.listener = this;
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

    @Override
    public void onHistorySelected(Historylist selectedHistory) {
       // Toast.makeText(this,selectedHistory +"History is selected ",Toast.LENGTH_LONG).show();
        openDetailedHistory(selectedHistory);
    }
    private void openDetailedHistory(Historylist selectedHistory){
          Intent detailedintent = new Intent(this,DetailedHistoryActivity.class);
          detailedintent.putExtra("dethistory",selectedHistory);
         startActivity(detailedintent);

    }
}
