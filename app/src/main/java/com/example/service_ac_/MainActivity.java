package com.example.service_ac_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //deklarasi
    LinearLayout main3;
    LinearLayout main4;
    LinearLayout main5;
    LinearLayout main6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main3 = (LinearLayout) findViewById(R.id.main3);
        main4 = (LinearLayout) findViewById(R.id.main4);
        main5 = (LinearLayout) findViewById(R.id.main5);
        main6 = (LinearLayout) findViewById(R.id.main6);


        //berpindah ke activity_chart

        //berpindah ke activity_Galery
        main3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Galery.class);
                startActivity(intent);
            }
        });
        //berpindah ke activity_about
        main4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
        //berpindah ke activity_bill
        main5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bill.class);
                startActivity(intent);
            }
        });
        //berpindah ke activity_pembelian_baju
        main6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PesanService.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);

    }

}
