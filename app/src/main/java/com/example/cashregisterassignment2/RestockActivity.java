package com.example.cashregisterassignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity {
 Button save;
 Button cancel;
 ListView list_view;
 EditText editText;
 CashBaseAdapter adapter;
 int userQnty;
 int selectedPosition;
 ArrayList<Productlist> stocklist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        list_view = findViewById(R.id.stocklist);
        editText = findViewById(R.id.edittext);
        stocklist =((myAPP)getApplication()).getManager().productArray;//herer
        System.out.println("My Stocklist :" +((myAPP)getApplication()).getManager().productArray);
        adapter = new CashBaseAdapter(this,stocklist);
        list_view.setAdapter(adapter);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(this,MainActivity.class);
////                startActivity(intent);
//                finish();
//            }
//        });

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
            }
        });

//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(editText.getText().toString().isEmpty())
//                {
//                    Toast.makeText(this, "All fields are Required", Toast.LENGTH_SHORT).show();
//                }
//                if(!editText.getText().toString().isEmpty()){
//                    userQnty = Integer.parseInt(editText.getText().toString()); // string from the Edittext
//                    int oldqnty = stocklist.get(selectedPosition).getQuantity();//get the quantity from the arrayist
//                    int newqnty = userQnty+oldqnty;// add the userentertd qnty to qnty in the arraylist
//                    stocklist.get(selectedPosition).setQuantity(newqnty); // set the new quantity in to arraylist
//                    adapter.notifyDataSetChanged(); // notify change
//
//                }
//
//            }
//        });

    }


    public void Cancelclicked(View view) {
        Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
    }

    public void saveClicked(View view) {
        if(editText.getText().toString().isEmpty())
                {
                    Toast.makeText(this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    userQnty = Integer.parseInt(editText.getText().toString()); // string from the Edittext
                    int oldqnty = stocklist.get(selectedPosition).getQuantity();//get the quantity from the arrayist
                    int newqnty = userQnty+oldqnty;// add the userentertd qnty to qnty in the arraylist
                    stocklist.get(selectedPosition).setQuantity(newqnty); // set the new quantity in to arraylist
                    adapter.notifyDataSetChanged(); // notify change
                }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}