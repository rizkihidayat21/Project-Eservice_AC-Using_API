package com.example.service_ac_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Galery extends AppCompatActivity {
    //deklarasi variable baru
    ImageView pic1;
    ImageView pic2;
    ImageView pic3;
    ImageView pic4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        //untuk menghubungkan galery.java dengan id activity_pembelian_baju
        pic1 = (ImageView) findViewById(R.id.pic1);
        pic2 = (ImageView) findViewById(R.id.pic2);
        pic3 = (ImageView) findViewById(R.id.pic3);
        //untuk menghubungkan pic pertama dengan detail.java
        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Galery.this, Detail.class);
                startActivity(intent);
            }
        });
        //untuk menghubungkan pic kedua dengan detail2.java
        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Galery.this, Detail2.class);
                startActivity(intent);
            }
        });
        //untuk menghubungkan pic ketiga dengan detail3.java
        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Galery.this, Detail3.class);
                startActivity(intent);
            }
        });

    }
}
