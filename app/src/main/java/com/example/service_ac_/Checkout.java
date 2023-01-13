package com.example.service_ac_;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Bundle b = getIntent().getExtras();
        TextView textnama = findViewById(R.id.textnama);
        TextView textalamat = findViewById(R.id.textalamat);
        TextView texttelepon = findViewById(R.id.texttelepon);
        TextView textproduk = findViewById(R.id.textproduk);
        TextView textukuran = findViewById(R.id.textukuran);
        TextView textharga = findViewById(R.id.textharga);
        TextView textjumlah = findViewById(R.id.textjumlah);
        TextView texttotal = findViewById(R.id.texttotal);

        textnama.setText(b.getCharSequence("nama"));
        texttelepon.setText(b.getCharSequence("telepon"));
        textalamat.setText(b.getCharSequence("alamat"));
        textproduk.setText(b.getCharSequence("produk"));
        textharga.setText(b.getCharSequence("harga"));
        textukuran.setText(b.getCharSequence("kode"));
        textjumlah.setText(b.getCharSequence("jumlah"));
        texttotal.setText(b.getCharSequence("total"));
    }

}

