package com.example.service_ac_;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class PesanService extends ListActivity {
    //untuk buat objek dari kelas DataHelper.java
    DataHelper dataHelper = new DataHelper(this);
    //untuk menyimpan nilai string
    public String[] xnama;
    public String[] xalamat;
    public String[] xtelpon;
    public String[] xproduk;
    public String[] xkode;
    public String[] xjumlah;
    public String[] xharga;
    public String[] xtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pembelian_baju);
        //memanggil data tabel_cloth dan ditampung oleh array
        ArrayList<HashMap<String, String>> arrayListCloth = dataHelper.cloth();
        xnama = new String[arrayListCloth.size()];
        xalamat = new String[arrayListCloth.size()];
        xtelpon = new String[arrayListCloth.size()];
        xproduk = new String[arrayListCloth.size()];
        xkode = new String[arrayListCloth.size()];
        xjumlah = new String[arrayListCloth.size()];
        xharga = new String[arrayListCloth.size()];
        xtotal = new String[arrayListCloth.size()];
        //digunakan untuk mengisi data tabel yang ditampung array
        if (arrayListCloth.size() > 0) {
            for (int i = 0; i < arrayListCloth.size(); i++) {
                HashMap<String, String> hashMapRecordCloth = arrayListCloth.get(i);
                String nama = hashMapRecordCloth.get("nama");
                String alamat = hashMapRecordCloth.get("alamat");
                String telpon = hashMapRecordCloth.get("telpon");
                String produk = hashMapRecordCloth.get("produk");
                String kode = hashMapRecordCloth.get("kode");
                String jumlah = hashMapRecordCloth.get("jumlah");
                String harga = hashMapRecordCloth.get("harga");
                String total = hashMapRecordCloth.get("total");

                System.out.println("Nama:" + nama);
                System.out.println("Alamat:" + alamat);
                System.out.println("Telpon:" + telpon);
                System.out.println("Produk:" + produk);
                System.out.println("kode:" + kode);
                System.out.println("Jumlah:" + jumlah);
                System.out.println("Harga:" + harga);
                System.out.println("Total:" + total);

                xnama[i] = nama;
                xalamat[i] = alamat;
                xtelpon[i] = telpon;
                xproduk[i] = produk;
                xkode[i] = kode;
                xjumlah[i] = jumlah;
                xharga[i] = harga;
                xtotal[i] = total;
            }

            for (int i = 0; i < arrayListCloth.size(); i++) {
                System.out.println(xnama[i]);
                System.out.println(xproduk[i]);
            }
            System.out.println("selesai");

        }
        //menghubungkan ListAdapter dengan data
        ListAdapter adapter = new ListAdapter(getBaseContext(), xnama, xalamat, xtelpon, xproduk, xkode, xjumlah, xharga, xtotal);
        setListAdapter(adapter);

    }
    //berpindah ke activity_pembelian_baju dengan membawa nilai String
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent kirim = new Intent(getApplicationContext(), DetailService.class);
        kirim.putExtra("nama", xnama[position].toString());
        kirim.putExtra("alamat", xalamat[position].toString());
        kirim.putExtra("telpon", xtelpon[position].toString());
        kirim.putExtra("produk", xproduk[position].toString());
        kirim.putExtra("ukuran", xkode[position].toString());
        kirim.putExtra("jumlah", xjumlah[position].toString());
        kirim.putExtra("harga", xharga[position].toString());
        kirim.putExtra("total", xtotal[position].toString());
        startActivity(kirim);
    }

    public void onBackPressed() {
        Intent intent = new Intent(PesanService.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
