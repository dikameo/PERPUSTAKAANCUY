package com.main.database;

public class NonFiksi extends Book{
    private String kategori = "NonFiksi";
    public NonFiksi(String kodeBuku, String judulBuku, String penulisBuku, String terbitan, String kategori, String lokasi, int stok){
        super (kodeBuku, judulBuku, penulisBuku, terbitan, kategori, lokasi, stok);
        super.setKategori(kategori);
    }
    @Override
    public String getKategori(){return kategori;}
}
