package com.example.foodmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class CartActivity extends AppCompatActivity {

    Bundle bundle;
    ImageView imageViewFirst,imageViewTwice,imageViewThird,imageViewFour, Bottom ;
    TextView textViewFirst, textViewTwice, textViewThird, textViewFour,
             priceFirst, priceTwice, priceThird,priceFour;

    int[] imageViews = {
            R.drawable.main_noprice,
            R.drawable.roje_noprice,
            R.drawable.mararoje_noprice,
            R.drawable.bazil_noprice
    };

    String[] MenuName = {
            "메인 떡볶이",
            "로제 떡볶이",
            "마라로제 떡볶이",
            "바질 떡볶이"
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
        SetPrice();
    }
    private void Init(){
        imageViewFirst = findViewById(R.id.firstView);
        imageViewTwice = findViewById(R.id.twiceView);
        imageViewThird = findViewById(R.id.thirdView);
        imageViewFour = findViewById(R.id.fourView);
        textViewFirst = findViewById(R.id.textView);
        textViewTwice =  findViewById(R.id.textView2);
        textViewThird = findViewById(R.id.textView3);
        textViewFour = findViewById(R.id.textView4);

        priceFirst = findViewById(R.id.firstPrice);
        priceTwice = findViewById(R.id.twicePrice);
        priceThird = findViewById(R.id.thirdPrice);
        priceFour = findViewById(R.id.fourPrice);

        Bottom = findViewById(R.id.bottom_button);

        Bottom.setOnClickListener(BottomButton);

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
    private void SetText() {
        if (bundle.getIntArray("textViewSet").length == 2) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0]) + "개");
            textViewTwice.setText("");
            textViewThird.setText("");
            textViewFour.setText("");
        } else if (bundle.getIntArray("textViewSet").length == 3) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0]) + "개");
            textViewTwice.setText(String.valueOf(bundle.getIntArray("textViewSet")[1]) + "개");
            textViewThird.setText("");
            textViewFour.setText("");
        } else if (bundle.getIntArray("textViewSet").length == 4) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0]) + "개");
            textViewTwice.setText(String.valueOf(bundle.getIntArray("textViewSet")[1]) + "개");
            textViewThird.setText(String.valueOf(bundle.getIntArray("textViewSet")[2]) + "개");
            textViewFour.setText("");
        } else if (bundle.getIntArray("textViewSet").length == 5) {
            textViewFirst.setText(String.valueOf(bundle.getIntArray("textViewSet")[0]) + "개");
            textViewTwice.setText(String.valueOf(bundle.getIntArray("textViewSet")[1]) + "개");
            textViewThird.setText(String.valueOf(bundle.getIntArray("textViewSet")[2]) + "개");
            textViewFour.setText(String.valueOf(bundle.getIntArray("textViewSet")[3]) + "개");
        }
    }

    private void SetPrice() {
        if (bundle.getIntArray("priceSet").length == 2) {
            priceFirst.setText(String.valueOf(bundle.getIntArray("priceSet")[0]) + "원");
            priceTwice.setText("");
            priceThird.setText("");
            priceFour.setText("");
        } else if (bundle.getIntArray("priceSet").length == 3) {
            priceFirst.setText(String.valueOf(bundle.getIntArray("priceSet")[0]) + "원");
            priceTwice.setText(String.valueOf(bundle.getIntArray("priceSet")[1]) + "원");
            priceThird.setText("");
            priceFour.setText("");
        } else if (bundle.getIntArray("priceSet").length == 4) {
            priceFirst.setText(String.valueOf(bundle.getIntArray("priceSet")[0]) + "원");
            priceTwice.setText(String.valueOf(bundle.getIntArray("priceSet")[1]) + "원");
            priceThird.setText(String.valueOf(bundle.getIntArray("priceSet")[2]) + "원");
            priceFour.setText("");
        } else if (bundle.getIntArray("priceSet").length == 5) {
            priceFirst.setText(String.valueOf(bundle.getIntArray("priceSet")[0]) + "원");
            priceTwice.setText(String.valueOf(bundle.getIntArray("priceSet")[1]) + "원");
            priceThird.setText(String.valueOf(bundle.getIntArray("priceSet")[2]) + "원");
            priceFour.setText(String.valueOf(bundle.getIntArray("priceSet")[3]) + "원");
        }
    }
    private View.OnClickListener BottomButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Workbook workbook = new HSSFWorkbook();

            Sheet sheet = workbook.createSheet(); // 새로운 시트 생성

            Row row = sheet.createRow(0); // 새로운 행 생성
            Cell cell;

            cell = row.createCell(0);
            cell.setCellValue("메뉴명");
            cell = row.createCell(1);
            cell.setCellValue("수량");
            cell = row.createCell(2);
            cell.setCellValue("총 가격");

            for(int i = 0; i< bundle.getIntArray("imageViewSet").length-1; i++){
                row = sheet.createRow(i + 1);
                cell = row.createCell(0);
                cell.setCellValue(MenuName[bundle.getIntArray("imageViewSet")[i]]);
                cell = row.createCell(1);
                cell.setCellValue(bundle.getIntArray("textViewSet")[i]+"개");
                cell = row.createCell(2);
                cell.setCellValue(bundle.getIntArray("priceSet")[i]);
            }
            File xlsFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "order.xls");

            try{
                FileOutputStream os = new FileOutputStream(xlsFile);
                workbook.write(os); // 외부 저장소에 엑셀 파일 생성
            }catch (IOException e){
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(),xlsFile.getAbsolutePath()+"에 저장되었습니다",Toast.LENGTH_SHORT).show();
            System.out.println(xlsFile.getAbsolutePath()+"에 저장되었습니다");
        }
    };
}
