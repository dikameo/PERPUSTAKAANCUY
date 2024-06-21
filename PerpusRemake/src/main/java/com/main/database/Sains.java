package com.main.database;

public class Sains extends Book{
    private String kategori = "Sains";
    public Sains(String kodeBuku, String judulBuku, String penulisBuku, String terbitan, String kategori, String lokasi, int stok){
        super (kodeBuku, judulBuku, penulisBuku, terbitan, kategori, lokasi, stok);
        super.setKategori(kategori);
    }
    @Override
    public String getKategori(){return kategori;}
}
