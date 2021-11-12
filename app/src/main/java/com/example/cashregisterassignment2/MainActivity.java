package com.example.cashregisterassignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    ListView list_view;
    TextView product_name;
    String text = "";
    Button buttonC;
    Button buyButton;
    TextView textquantity;
    int selectedPosition;
    TextView viewAmount;
    boolean isavailable = false;
    ProductManager managerobj = new ProductManager();
    CashBaseAdapter adapter;
    double total;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        buttonC = findViewById(R.id.buttonCancel);
        buyButton = findViewById(R.id.buyButton);
        textquantity = findViewById(R.id.textViewquantity);
        viewAmount = findViewById(R.id.textViewamount);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        button0.setOnClickListener(this);
        buyButton.setOnClickListener(this);

        managerobj.addtoArray();
         list_view = findViewById(R.id.listproduct);
         product_name= findViewById(R.id.textViewproduct);
         adapter = new CashBaseAdapter(this, managerobj.productArray);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                product_name.setText(managerobj.productArray.get(position).getProductname());
                selectedPosition = position;

            }
        });
    }
    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttontitle = button.getText().toString();
        if(v == buttonC){
            text = "";
            textquantity.setText("");
            viewAmount.setText("");
            product_name.setText("");
                    }
        else if(v== buyButton ) {
            if(text.isEmpty())
            { Toast.makeText(this,"All fields are required ", Toast.LENGTH_LONG).show();
            //System.out.println("Text is empty");
                //adaptor.notifyDataSetChanged();
                }
            else{
                int userqnty = Integer.parseInt((String) textquantity.getText());
                isavailable = managerobj.checkQuantity(selectedPosition,userqnty);
                if(isavailable){
                    System.out.println("Yes truee Its available");
                    adapter.notifyDataSetChanged();
                    alertDialog();
                }
            }

               }
        else {
            text = text + buttontitle;
            textquantity.setText(text);
            double price = managerobj.productArray.get(selectedPosition).getPrice();
            int quantity = Integer.parseInt(text);
            total = price*quantity;
            viewAmount.setText(total+"");
            isavailable = managerobj.checkQuantity(selectedPosition,quantity);
            if(isavailable == false){
                Toast.makeText(this,"Not Enough Quantity ", Toast.LENGTH_LONG).show();

            }
        }

    }
    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        String prodname = managerobj.productArray.get(selectedPosition).getProductname();
        dialog.setMessage("Your Total Purchase for  "+text+" "+ prodname+ " is " +total);
        dialog.setTitle("Thank You For Your Purchase");
        dialog.setPositiveButton("YES",new DialogInterface.OnClickListener()
              {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }


}