package com.example.cashregisterassignment2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class Historylist extends Productlist implements Parcelable {
     private String date;
     private double total;

    public Historylist(String productname, int quantity, double price, String date, double total) {
        super(productname, quantity, price);
        this.date = date;
        this.total = total;
    }

//    public Historylist() {
//       // super();
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public String toString(){
        return "[" + getProductname() + "," + getQuantity() + "," + getPrice()+"," + getDate() + "," + getTotal() +  "]";
    }
    protected Historylist(Parcel in) {
//        productname = in.readString();
//        quantity = in.readInt();
//        price = in.readDouble();
        super(in);
        date = in.readString();
        total = in.readDouble();
    }
    public static final Creator<Historylist> CREATOR = new Creator<Historylist>() {
        @Override
        public Historylist createFromParcel(Parcel in) {
            return new Historylist(in);
        }

        @Override
        public Historylist [] newArray(int size) {
            return new Historylist [size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(productname);
//        dest.writeInt(quantity);
//        dest.writeDouble(price);
        super.writeToParcel(dest,flags);
        dest.writeString(date);
        dest.writeDouble(total);
    }


}
