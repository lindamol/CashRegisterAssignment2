package com.example.cashregisterassignment2;

import java.util.ArrayList;

public class ProductManager {
    ArrayList<Productlist> productArray = new ArrayList<>();
    Productlist list1 = new Productlist("Pants",30,200);
        Productlist list2 = new Productlist("Shoes",90,180);
        Productlist list3 = new Productlist("Shirts",300,250);

     void addtoArray(){
                productArray.add(list1);
                productArray.add(list2);
                productArray.add(list3);
                 }
    void printArray()
    { System.out.println(productArray.toString()); }

    boolean checkQuantity(int position, int quantity){
         boolean isavailable = false;
         if(quantity <= productArray.get(position).quantity){
             isavailable = true;
             productArray.get(position).quantity = productArray.get(position).quantity - quantity;
             System.out.println("Remaining Quantity is "+productArray.get(position).quantity );
                      }
         else { isavailable = false;
             System.out.println(isavailable+"");
         }
         return isavailable;
    }

}
