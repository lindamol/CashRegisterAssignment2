package com.example.cashregisterassignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CashBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<Productlist> mylist;
    //should create Array list to populate
    //should know context,ie where exactly I am going oto work
    //need layout inflator to build the list/row
    // recieve the arraylist form other class we can create a cashabseadaptor constructor and gets
    //the array luist here.
    public CashBaseAdapter(Context context, ArrayList<Productlist> mylist) {
        this.context = context;
        this.mylist = mylist;
    }
    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = LayoutInflater.from(context).inflate(R.layout.list_row_layout,null);
       TextView prodname = convertView.findViewById(R.id.productid);
       TextView qnty = convertView.findViewById(R.id.quantityid);
       TextView price = convertView.findViewById(R.id.priceid);
       prodname.setText(mylist.get(position).getProductname());
       qnty.setText(mylist.get(position).getQuantity()+"");
       price.setText(mylist.get(position).getPrice()+"");
       return convertView;
    }

}
