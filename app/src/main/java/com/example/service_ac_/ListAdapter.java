package com.example.service_ac_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {
    //untuk menerima nilai string
    private final Context context;
    private final String[] nama;
    private final String[] alamat;
    private final String[] telpon;
    private final String[] produk;
    private final String[] kode;
    private final String[] jumlah;
    private final String[] harga;
    private final String[] total;
    //sebagai penghubung interface yang ada pada ListAdapter dengan activity_pembelian_baju
    public ListAdapter(Context context,String[] nama, String[] alamat, String[] telpon, String[] produk, String[] kode, String[] jumlah, String[] harga, String[] total){
        super(context, R.layout.activity_pesan_service, nama);
        this.context = context;
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
        this.produk = produk;
        this.kode = kode;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = total;
    }
    //menampilkan data yang ada pada activity_pembelian_baju
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //menghubungan antara variable ListAdapter.java dengan id yang ada oada activity_pembelian_baju
        View rowView = inflater.inflate(R.layout.activity_pesan_service, parent, false);
        TextView xnama = (TextView) rowView.findViewById(R.id.nama);
        TextView xproduk = (TextView) rowView.findViewById(R.id.baju);
        //memberi nilai string hasil dari data
        xnama.setText(nama[position]);
        xproduk.setText(produk[position]);
        return rowView;
    }
}