package com.main.database;

public class Book {
    private String kodeBuku, judulBuku, penulisBuku, terbitan, kategori, lokasi;
    private int stok, durasi;
    public Book(String kodeBuku, String judulBuku, String penulisBuku, String terbitan, String kategori, String lokasi, int stok){
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.penulisBuku = penulisBuku;
        this.terbitan = terbitan;
        this.kategori = kategori;
        this.lokasi = lokasi;
        this.stok = stok;
        this.durasi = 0;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulisBuku() {
        return penulisBuku;
    }

    public void setPenulisBuku(String penulisBuku) {
        this.penulisBuku = penulisBuku;
    }

    public String getTerbitan() {
        return terbitan;
    }

    public void setTerbitan(String terbitan) {
        this.terbitan = terbitan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
}
