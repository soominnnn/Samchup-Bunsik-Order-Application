package com.example.foodmobile;

import android.widget.Toast;

public class Menu {
    private String name;
    private int price;

    private int count;
    private int Click;

    public Menu(String name, int price){
        this.name = name;
        this.price = price;
    }
    public int getCount(){
        return count;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int CountUp(){
        return this.count ++;
    }
    public int CountDown(){ return this.count--;}
    public int Click(){
        return this.Click = 1;
    }
    public int getClick(){
        return this.Click;
    }
}
