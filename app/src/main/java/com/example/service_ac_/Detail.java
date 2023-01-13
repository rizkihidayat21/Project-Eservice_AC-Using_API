package com.example.service_ac_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        buy = (Button) findViewById(R.id.buy);

        final TextView produk = (TextView) findViewById(R.id.pic);
        final TextView harga = (TextView) findViewById(R.id.harga);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detail.this, Billl.class);
                intent.putExtra("produk", produk.getText().toString().trim());
                intent.putExtra("harga", harga.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}
