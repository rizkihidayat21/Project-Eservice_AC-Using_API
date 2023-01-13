package com.example.service_ac_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DataHelper extends SQLiteOpenHelper {
    private static final String nama_database = "laporan.db"; //membuat database baru
    private static final int versi_database = 1; //versi database
    //membuat tabel baru, tabel_customer
    private static final String buat_tabel_barang = "CREATE TABLE IF NOT EXISTS tabel_customer(nama TEXT, alamat TEXT, telpon TEXT, produk TEXT, kode TEXT, jumlah INTEGER, harga INTEGER, total INTEGER)";
    private static final  String hapus_tabel = "DROP TABLE IF EXISTS buat_tabel";

    public DataHelper(Context context){
        super(context, nama_database, null, versi_database);
    }
    //eksekusi pembuatan tabel_cloth
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL((buat_tabel_barang));
        System.out.println("tabel_customer sudah dibuat");
    }
    //upgrade database lama menjadi terbaru
    @Override
    public void onUpgrade(SQLiteDatabase database, int versi_lama, int versi_baru) {
        database.execSQL(hapus_tabel);
        onCreate(database);
    }
    //mengambil data dari database dan menyiapkan penyimpanan data(array)
    public ArrayList<HashMap<String, String>> cloth(){
        ArrayList<HashMap<String, String>> arrayListCloth = new ArrayList<HashMap<String, String>>();

        SQLiteDatabase database = this.getWritableDatabase();
        //melihat isi data dari tabel_customer
        Cursor cursor = database.rawQuery("SELECT * FROM tabel_customer", null);

        if (cursor.moveToFirst()){
            do {
                HashMap<String, String> hashMapCloth = new HashMap<String, String>();

                hashMapCloth.put("nama", cursor.getString(0));
                hashMapCloth.put("alamat", cursor.getString(1));
                hashMapCloth.put("telpon", cursor.getString(2));
                hashMapCloth.put("produk", cursor.getString(3));
                hashMapCloth.put("kode", cursor.getString(4));
                hashMapCloth.put("jumlah", cursor.getString(5));
                hashMapCloth.put("harga", cursor.getString(6));
                hashMapCloth.put("total", cursor.getString(7));

                arrayListCloth.add(hashMapCloth);
            } while (cursor.moveToNext());
        }
        return arrayListCloth;
    }
    //berfungsi untuk menambahkan data ke tabel_customer
    public int update_barang(String nama, String alamat, String telpon, String produk, String kode, int jumlah, int harga, int total){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues recordcloth = new ContentValues();
        recordcloth.put("nama", nama);
        recordcloth.put("alamat", alamat);
        recordcloth.put("telpon", telpon);
        recordcloth.put("produk", produk);
        recordcloth.put("kode", kode);
        recordcloth.put("jumlah", jumlah);
        recordcloth.put("harga", harga);
        recordcloth.put("total", total);
        return  database.update("tabel_cloth", recordcloth, "nama= '" + nama+"'", null);
    }
    //untuk hapus data dari tabel_customer
    public void hapus_barang(String nama){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM tabel_customer where nama='" + nama+"'");
        database.close();
    }
    //untuk tambah data dari tabel_customer
    public void tambah_cloth(String xnama, String xalamat, String xtelpon, String xproduk, String xkode, String xjumlah, String xharga, String xtotal) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put("nama", xnama);
        values.put("alamat", xalamat);
        values.put("telpon", xtelpon);
        values.put("produk", xproduk);
        values.put("kode", xkode);
        values.put("jumlah", xjumlah);
        values.put("harga", xharga);
        values.put("total", xtotal);
        database.insert("tabel_customer", null, values);
        database.close();
    }
}