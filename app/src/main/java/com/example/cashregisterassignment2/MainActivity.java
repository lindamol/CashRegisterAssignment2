package com.example.cashregisterassignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    ListView list_view;
    TextView product_name;
    String text = "";
    Button buttonC;
    Button buyButton;
    TextView textquantity;
    int selectedPosition;
    int quantity;
    TextView viewAmount;
    boolean isavailable = false;
   //static  ProductManager managerobj = new ProductManager();
   //ProductManager manger = ((myAPP)getApplication()).getManager();
   // static  Historylist historyobj = new Historylist();
    CashBaseAdapter adapter;
    double total;
   //AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //builder = new AlertDialog.Builder(this);
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
        Button buttonmanager = (Button)findViewById(R.id.buttonmanager);
        buttonmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManagerActivity();
            } // Manger Button
        });
       // managerobj.addtoArray();
        //ProductManager managerobj = new ProductManager();
         list_view = findViewById(R.id.listproduct);
         product_name= findViewById(R.id.textViewproduct);
         adapter = new CashBaseAdapter(this, ((myAPP)getApplication()).getManager().productArray);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                product_name.setText(((myAPP)getApplication()).getManager().productArray.get(position).getProductname());
                selectedPosition = position;
            }
        });

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttontitle = button.getText().toString();
        if(v == buttonC){ //CancelButton
            text = "";
            textquantity.setText("");
            viewAmount.setText("");
            product_name.setText("");
                    }
        else if(v== buyButton ) {
            if(text.isEmpty()|| product_name.getText() == "") //clicking on buybutton checks whether fields are empty or not
            { Toast.makeText(this,"All fields are required ", Toast.LENGTH_LONG).show();
            }
            else{
                boolean isvalid = ((myAPP)getApplication()).getManager().purchaseHistory(selectedPosition,quantity);
                if(isvalid)
                {adapter.notifyDataSetChanged();//To update listview after each purchase
                    //String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());//date in string format
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd , HH:mm:ss", Locale.getDefault());
                    String date = sdf.format(new Date());
                    ((myAPP)getApplication()).getManager().addtoHistory(date,selectedPosition,total,quantity); // passing the purchase details to history
                    ((myAPP)getApplication()).getManager().printhistory();// To debug
                    alertDialog();} // Alert dialog after Purchase
                else{Toast.makeText(this,"Not Enough Quantity ", Toast.LENGTH_LONG).show();}
            }

               }
        else { //All digit presses
            text = text + buttontitle;
            textquantity.setText(text);
            isavailable = ((myAPP)getApplication()).getManager().checkQuantity(selectedPosition,Integer.parseInt(text)); //checking quantity
            if(isavailable == false){
                Toast.makeText(this,"Not Enough Quantity ", Toast.LENGTH_LONG).show();
            }
            //setting quantity as what we pressed
              quantity = Integer.parseInt(text);
            // Calculating each time When a quantity is selected
            if((product_name.getText())!="" )
            {total = ((myAPP)getApplication()).getManager().calculatePrice(selectedPosition,quantity);
             viewAmount.setText(total+"");}
            else{Toast.makeText(this,"All fields are required ", Toast.LENGTH_LONG).show();}
                   }
    }

    // Create an Alert with Message and two Button/OK and cancel
    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        String prodname = ((myAPP)getApplication()).getManager().productArray.get(selectedPosition).getProductname();
        dialog.setMessage("Your Total Purchase for  "+text+" "+ prodname+ " is $" +total);
        dialog.setTitle("Thank You For Your Purchase \uD83D\uDE04 ");
        dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() //for OK Button positive
              {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });

        dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() { // for cancel button Negative
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
    //To open ManagerActivity
    private void openManagerActivity(){
        Intent managerintent = new Intent(this,ManagerActivity.class);
        Bundle bundlemanager = new Bundle();
        bundlemanager.putParcelableArrayList("history",((myAPP)getApplication()).getManager().historyArray);
        managerintent.putExtras(bundlemanager);
        startActivity(managerintent);

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}