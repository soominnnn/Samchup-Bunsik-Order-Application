package com.example.foodmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {
    Intent intent;
    ImageView imageButton,cartBtn_main, cartBtn_roje, cartBtn_mara, cartBtn_bazil;
    Menu main, roje, mara, bazil;
    Bundle bundle;
    Button plusMain, minusMain, plusRoje, minusRoje, plusMararoje, minusMararoje, plusBazil, minusBazil;
    TextView countMain,countRoje, countMararoje, countBazil;

    int count = 0;
    int ArrayLength = 1;
    int ArrCount = 0;

    private int [] imageviewSet;
    private int [] textViewSet ;

    private int [] priceSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        intent = new Intent(MenuActivity.this, CartActivity.class);
        menuInit();
        Viewinit();
    }
    void menuInit(){
        main = new Menu("삼첩 떡볶이", 7000);
        roje = new Menu("로제 떡볶이",8000);
        mara = new Menu("마라로제 떡볶이",9000);
        bazil = new Menu("바질크림 떡볶이",10000);
    }
    public void Viewinit(){
        imageButton = findViewById(R.id.bottom_button);

        plusMain = findViewById(R.id.plus_main);
        minusMain = findViewById(R.id.minus_main);
        plusRoje = findViewById(R.id.plus_roje);
        minusRoje = findViewById(R.id.minus_roje);
        plusMararoje = findViewById(R.id.plus_mararoje);
        minusMararoje = findViewById(R.id.minus_mararoje);
        plusBazil = findViewById(R.id.plus_bazil);
        minusBazil = findViewById(R.id.minus_bazil);

        countMain = findViewById(R.id.main_count);
        countRoje = findViewById(R.id.roje_count);
        countMararoje = findViewById(R.id.mararoje_count);
        countBazil = findViewById(R.id.bazil_count);

        cartBtn_main = findViewById(R.id.cartBtn_main);
        cartBtn_roje = findViewById(R.id.cartBtn_roje);
        cartBtn_mara = findViewById(R.id.cartBtn_mara);
        cartBtn_bazil = findViewById(R.id.cartBtn_bazil);


        plusMain.setOnClickListener(plusMainClick);
        minusMain.setOnClickListener(minusMainClick);
        plusRoje.setOnClickListener(plusRojeClick);
        minusRoje.setOnClickListener(minusRojeClick);
        plusMararoje.setOnClickListener(plusMaraRojeClick);
        minusMararoje.setOnClickListener(minusMaraRojeClick);
        plusBazil.setOnClickListener(plusBazilClick);
        minusBazil.setOnClickListener(minusBazilClick);

        imageButton.setOnClickListener(imageButtonClick);
        cartBtn_main.setOnClickListener(cart_main);
        cartBtn_roje.setOnClickListener(cart_roje);
        cartBtn_mara.setOnClickListener(cart_mara);
        cartBtn_bazil.setOnClickListener(cart_bazil);
        bundle = new Bundle();
    }
    private View.OnClickListener imageButtonClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if(count == 0){
                Toast.makeText(getApplicationContext(),"음식을 선택해주세요!",Toast.LENGTH_SHORT).show();
            }
            else{
                imageviewSet = new int[ArrayLength];
                textViewSet = new int[ArrayLength];
                priceSet = new int[ArrayLength];


                if(main.getClick() == 1){
                    imageviewSet[ArrCount] = 0;
                    textViewSet[ArrCount] = main.getCount();
                    priceSet[ArrCount] = main.getCount()*main.getPrice();
                    ArrCount++;
                }

                if(roje.getClick() == 1){
                    imageviewSet[ArrCount] = 1;
                    textViewSet[ArrCount] = roje.getCount();
                    priceSet[ArrCount] = roje.getCount()*roje.getPrice();
                    ArrCount++;
                }
                if( mara.getClick() == 1){
                    imageviewSet[ArrCount] = 2;
                    textViewSet[ArrCount] = mara.getCount();
                    priceSet[ArrCount] = mara.getCount()*mara.getPrice();
                    ArrCount++;
                }
                if( bazil.getClick() == 1){
                    imageviewSet[ArrCount] = 3;
                    textViewSet[ArrCount] = bazil.getCount();
                    priceSet[ArrCount] = bazil.getCount()*bazil.getPrice();
                    ArrCount++;
                }
                bundle.putIntArray("imageViewSet",imageviewSet);
                bundle.putIntArray("textViewSet", textViewSet);
                bundle.putIntArray("priceSet",priceSet);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener plusMainClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if(main.getCount()>=99){
                Toast.makeText(getApplicationContext(),"99개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                main.CountUp();
                countMain.setText(String.valueOf(main.getCount()));
            }
        }
    };
    private View.OnClickListener minusMainClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(main.getCount() <= 0){
                Toast.makeText(getApplicationContext(),"1개 이상 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                main.CountDown();
                countMain.setText(String.valueOf(main.getCount()));
            }
        }
    };
    private View.OnClickListener plusRojeClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if(roje.getCount()>=99){
                Toast.makeText(getApplicationContext(),"99개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                roje.CountUp();
                countRoje.setText(String.valueOf(roje.getCount()));
            }
        }
    };
    private View.OnClickListener minusRojeClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(roje.getCount() <= 0){
                Toast.makeText(getApplicationContext(),"1개 이상 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                roje.CountDown();
                countRoje.setText(String.valueOf(roje.getCount()));
            }
        }
    };
    private View.OnClickListener plusMaraRojeClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if(mara.getCount()>=99){
                Toast.makeText(getApplicationContext(),"99개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                mara.CountUp();
                countMararoje.setText(String.valueOf(mara.getCount()));
            }
        }
    };
    private View.OnClickListener minusMaraRojeClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mara.getCount() <= 0){
                Toast.makeText(getApplicationContext(),"1개 이상 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                mara.CountDown();
                countMararoje.setText(String.valueOf(mara.getCount()));
            }
        }
    };
    private View.OnClickListener plusBazilClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            if(bazil.getCount()>=99){
                Toast.makeText(getApplicationContext(),"99개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                bazil.CountUp();
                countBazil.setText(String.valueOf(bazil.getCount()));
            }
        }
    };
    private View.OnClickListener minusBazilClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(bazil.getCount() <= 0){
                Toast.makeText(getApplicationContext(),"1개 이상 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                bazil.CountDown();
                countBazil.setText(String.valueOf(bazil.getCount()));
            }
        }
    };

    private View.OnClickListener cart_main = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(main.getClick() == 1){
                Toast.makeText(getApplicationContext(),"하나의 음식은 한번만 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                if(count == 4){
                    Toast.makeText(getApplicationContext(),"음식은 4개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
                }
                else if(count < 4){
                    Toast.makeText(getApplicationContext(),"장바구니에 추가되었습니다.",Toast.LENGTH_SHORT).show();
                    main.Click();
                    ArrayLength++;
                    count++;
                }
            }
        }
    };
    private View.OnClickListener cart_roje = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(roje.getClick() == 1){
                Toast.makeText(getApplicationContext(),"하나의 음식은 한번만 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                if(count == 4){
                    Toast.makeText(getApplicationContext(),"음식은 4개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
                }
                else if(count < 4){
                    count++;
                    Toast.makeText(getApplicationContext(),"장바구니에 추가되었습니다.",Toast.LENGTH_SHORT).show();
                    ArrayLength++;
                    roje.Click();
                }
            }
        }
    };
    private View.OnClickListener cart_mara = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mara.getClick() == 1){
                Toast.makeText(getApplicationContext(),"하나의 음식은 한번만 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                if(count == 4){
                    Toast.makeText(getApplicationContext(),"음식은 4개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
                }
                else if(count < 4){
                    mara.Click();
                    ArrayLength++;
                    count++;
                    Toast.makeText(getApplicationContext(),"장바구니에 추가되었습니다.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
    private View.OnClickListener cart_bazil = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(bazil.getClick() == 1){
                Toast.makeText(getApplicationContext(),"하나의 음식은 한번만 주문 가능합니다.",Toast.LENGTH_SHORT).show();
            }
            else{
                if(count == 4){
                    Toast.makeText(getApplicationContext(),"음식은 4개까지 주문 가능합니다.",Toast.LENGTH_SHORT).show();
                }
                else if(count < 4){
                    bazil.Click();
                    ArrayLength++;
                    count++;
                    Toast.makeText(getApplicationContext(),"장바구니에 추가되었습니다.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

}