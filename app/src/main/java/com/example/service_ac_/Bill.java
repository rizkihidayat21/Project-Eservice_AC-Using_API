package com.example.service_ac_;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Bill extends AppCompatActivity {
    //untuk buat objek dari kelas DataHelper.java
    DataHelper dataHelper = new DataHelper(com.example.service_ac_.Bill.this);
    //untuk menyimpan nilai string
    private String xnama;
    private String xalamat;
    private String xtelpon;
    private String xproduk;
    private String xkode;
    private String xjumlah;
    private String xharga;
    private String xtotal;

    RadioGroup pilihproduk;
    int harga=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        //menghubungkan antara variable bill.java dengan id activity_pembelian_baju
        final EditText nama = (EditText) findViewById(R.id.nama);
        final EditText alamat = (EditText) findViewById(R.id.alamat);
        final EditText telepon = (EditText) findViewById(R.id.telepon);
        pilihproduk = (RadioGroup) findViewById(R.id.pilihproduk);
        final EditText ukuran = (EditText) findViewById(R.id.ukuran);
        final EditText jumlah = (EditText) findViewById(R.id.jumlah);
        final Button buy = (Button) findViewById(R.id.buy);
        //untuk memberikan pilihan nilai
        pilihproduk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.produk1:
                        harga = 115000;
                        break;
                    case R.id.produk2:
                        harga = 105000;
                        break;
                    case R.id.produk3:
                        harga = 105000;
                        break;

                }
            }
        });
        //menentukan aksi ketika button buy diklik
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdata = new Intent(getApplicationContext(), Checkout.class);
                //mengirim data menuju activity_pembelian_baju
                Bundle b = new Bundle();
                b.putString("nama", nama.getText().toString());
                b.putString("alamat", alamat.getText().toString());
                b.putString("telepon", telepon.getText().toString());
                b.putString("kode", ukuran.getText().toString());
                b.putString("jumlah", jumlah.getText().toString());
                int pilih_produk = pilihproduk.getCheckedRadioButtonId();
                RadioButton rbproduk = (RadioButton) findViewById(pilih_produk);
                b.putString("produk", rbproduk.getText().toString());
                b.putString("harga", String.valueOf(harga));
                int jumlahbeli = Integer.parseInt(jumlah.getText().toString());
                int total = harga*jumlahbeli;
                b.putString("total", String.valueOf(total));
                intentdata.putExtras(b);
                //menyimpan hasil input di string
                xnama = nama.getText().toString();
                xalamat = alamat.getText().toString();
                xtelpon = telepon.getText().toString();
                xproduk = rbproduk.getText().toString();
                xkode = ukuran.getText().toString();
                xjumlah =  jumlah.getText().toString();
                xharga = String.valueOf(harga);
                xtotal =  String.valueOf(total);
                //menambah data tersimpan ke string tabel_cloth
                dataHelper.tambah_cloth(xnama, xalamat, xtelpon, xproduk ,xkode, xjumlah, xharga, xtotal);
                startActivity(intentdata);
                finish();
            }
        });
    }
}