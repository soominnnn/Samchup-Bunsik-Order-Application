package com.example.foodmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CartActivity extends AppCompatActivity {

    Bundle bundle;
    ImageView imageViewFirst,imageViewTwice,imageViewThird,imageViewFour ;
    TextView textViewFirst, textViewTwice, textViewThird, textViewFour;

    int[] imageViews = {
            R.drawable.main_teokbokki,
            R.drawable.roje_teokbokki,
            R.drawable.mararoje_teokbokki,
            R.drawable.bazil_teokbokki
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent intent = getIntent();
        bundle = new Bundle();
        bundle = intent.getExtras();
        Init();
        SetImage();
        SetText();
    }
    private void Init(){
        imageViewFirst = (ImageView) findViewById(R.id.firstView);
        imageViewTwice = (ImageView)findViewById(R.id.twiceView);
        imageViewThird = (ImageView)findViewById(R.id.thirdView);
        imageViewFour = (ImageView)findViewById(R.id.fourView);
        textViewFirst = (TextView)findViewById(R.id.textView);
        textViewTwice = (TextView) findViewById(R.id.textView2);
        textViewThird = (TextView)findViewById(R.id.textView3);
        textViewFour = (TextView)findViewById(R.id.textView4);

    }
    private void SetImage() {
        if(bundle.getIntArray("imageViewSet").length == 2) {
            imageViewFirst.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[0]]);
            imageViewTwice.setVisibility(View.GONE);
            imageViewThird.setVisibility(View.GONE);
            imageViewFour.setVisibility(View.GONE);
        }
        else if(bundle.getIntArray("imageViewSet").length == 3) {
            imageViewFirst.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[0]]);
            imageViewTwice.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[1]]);
            imageViewThird.setVisibility(View.GONE);
            imageViewFour.setVisibility(View.GONE);
        }
        else if(bundle.getIntArray("imageViewSet").length == 4) {
            imageViewFirst.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[0]]);
            imageViewTwice.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[1]]);
            imageViewThird.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[2]]);
            imageViewFour.setVisibility(View.GONE);
        }
        else if(bundle.getIntArray("imageViewSet").length == 5) {
            imageViewFirst.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[0]]);
            imageViewTwice.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[1]]);
            imageViewThird.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[2]]);
            imageViewFour.setImageResource(imageViews[bundle.getIntArray("imageViewSet")[3]]);
        }
    }
    private void SetText(){
        if(bundle.getIntArray("textViewSet").length == 2) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0])+"개");
            textViewTwice.setText("");
            textViewThird.setText("");
            textViewFour.setText("");
        }
        else if(bundle.getIntArray("textViewSet").length == 3) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0])+"개");
            textViewTwice.setText(String.valueOf(bundle.getIntArray("textViewSet")[1])+"개");
            textViewThird.setText("");
            textViewFour.setText("");
        }
        else if(bundle.getIntArray("textViewSet").length == 4) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0])+"개");
            textViewTwice.setText(String.valueOf(bundle.getIntArray("textViewSet")[1])+"개");
            textViewThird.setText(String.valueOf(bundle.getIntArray("textViewSet")[2])+"개");
            textViewFour.setText("");
        }
        else if(bundle.getIntArray("textViewSet").length == 5) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0])+"개");
            textViewTwice.setText(String.valueOf(bundle.getIntArray("textViewSet")[1])+"개");
            textViewThird.setText(String.valueOf(bundle.getIntArray("textViewSet")[2])+"개");
            textViewFour.setText(String.valueOf(bundle.getIntArray("textViewSet")[3])+"개");
        }
    }
}
