package com.example.service_ac_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Billl extends AppCompatActivity {
    //untuk buat objek dari kelas DataHelper.java
    DataHelper dataHelper = new DataHelper(this);
    //untuk menyimpan nilai string
    private String xnama;
    private String xalamat;
    private String xtelpon;
    private String xproduk;
    private String xkode;
    private String xjumlah;
    private String xharga;
    private String xtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billl);
        //menghubungkan antara variable billl.java dengan id activity_pembelian_baju
        final EditText nama = (EditText) findViewById(R.id.nama);
        final EditText alamat = (EditText) findViewById(R.id.alamat);
        final EditText telepon = (EditText) findViewById(R.id.telepon);
        final TextView produk = (TextView) findViewById(R.id.produk);
        final TextView harga = (TextView) findViewById(R.id.harga);
        final EditText ukuran = (EditText) findViewById(R.id.ukuran);
        final EditText jumlah = (EditText) findViewById(R.id.jumlah);
        final Button buy = (Button) findViewById(R.id.buy);
        //mengambil intent sebelumnya
        String product = getIntent().getStringExtra("produk");
        produk.setText(product);
        String hrga = getIntent().getStringExtra("harga");
        harga.setText(hrga);
        //untuk aksi ketika button buy diklik
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdata = new Intent(getApplicationContext(), Checkout.class);
                Bundle b = new Bundle();
                b.putString("nama", nama.getText().toString());
                b.putString("alamat", alamat.getText().toString());
                b.putString("telepon", telepon.getText().toString());
                b.putString("produk", produk.getText().toString());
                b.putString("harga", harga.getText().toString());
                b.putString("kode", ukuran.getText().toString());
                b.putString("jumlah", jumlah.getText().toString());
                //membuat rumusan perhitungan total bayar
                int hargabeli = Integer.parseInt(harga.getText().toString());
                int jumlahbeli = Integer.parseInt(jumlah.getText().toString());
                int total = hargabeli*jumlahbeli;
                b.putString("total", String.valueOf(total));
                intentdata.putExtras(b);
                //menyimpan hasil input di string
                xnama = nama.getText().toString();
                xalamat = alamat.getText().toString();
                xtelpon = telepon.getText().toString();
                xproduk = produk.getText().toString();
                xkode = ukuran.getText().toString();
                xjumlah =  jumlah.getText().toString();
                xharga = harga.getText().toString();
                xtotal =  String.valueOf(total);
                //menambah data tersimpan ke string tabel_cloth
                dataHelper.tambah_cloth(xnama, xalamat, xtelpon, xproduk ,xkode, xjumlah, xharga, xtotal);
                startActivity(intentdata);
                finish();
            }
        });
    }
}
