package com.main.UI;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import com.main.database.Book;
import java.util.ArrayList;
public class PropertyBook {
    private SimpleStringProperty kodeBuku;
    private SimpleStringProperty judulBuku;
    private SimpleStringProperty penulisBuku;
    private SimpleStringProperty terbitan;
    private SimpleStringProperty kategori;
    private SimpleStringProperty lokasi;
    private SimpleIntegerProperty stok;
    private SimpleStringProperty durasi;
    PropertyBook(String kodeBuku, String judulBuku, String penulisBuku, String terbitan, String kategori, String lokasi, int stok){
        this.kodeBuku = new SimpleStringProperty(kodeBuku);
        this.judulBuku = new SimpleStringProperty(judulBuku);
        this.penulisBuku = new SimpleStringProperty(penulisBuku);
        this.terbitan = new SimpleStringProperty(terbitan);
        this.kategori = new SimpleStringProperty(kategori);
        this.lokasi = new SimpleStringProperty(lokasi);
        this.stok = new SimpleIntegerProperty(stok);
        this.durasi = new SimpleIntegerProperty(durasi);
    }
    public static ArrayList<PropertyBook> bookToProperty (ArrayList<Book> arr){
        ArrayList<PropertyBook> temp =new ArrayList<>();
        for (Book book : arr) {
            PropertyBook obj = new PropertyBook(book.getKodeBuku(), book.getJudulBuku(), book.getPenulisBuku(),book.getTerbitan(),book.getKategori(),book.getLokasi(),book.getStok(),book.getDurasi());
            temp.add(obj);
        }
        return temp;
    }

    public String getKodeBuku() {
        return kodeBuku.get();
    }

    public SimpleStringProperty kodeBukuProperty() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku.set(kodeBuku);
    }

    public String getJudulBuku() {
        return judulBuku.get();
    }

    public SimpleStringProperty judulBukuProperty() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku.set(judulBuku);
    }

    public String getPenulisBuku() {
        return penulisBuku.get();
    }

    public SimpleStringProperty penulisBukuProperty() {
        return penulisBuku;
    }

    public void setPenulisBuku(String penulisBuku) {
        this.penulisBuku.set(penulisBuku);
    }

    public String getTerbitan() {
        return terbitan.get();
    }

    public SimpleStringProperty terbitanProperty() {
        return terbitan;
    }

    public void setTerbitan(String terbitan) {
        this.terbitan.set(terbitan);
    }

    public String getKategori() {
        return kategori.get();
    }

    public SimpleStringProperty kategoriProperty() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori.set(kategori);
    }

    public String getLokasi() {
        return lokasi.get();
    }

    public SimpleStringProperty lokasiProperty() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi.set(lokasi);
    }

    public int getStok() {
        return stok.get();
    }

    public SimpleIntegerProperty stokProperty() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok.set(stok);
    }

    public String getDurasi() {
        return durasi.get();
    }

    public SimpleStringProperty durasiProperty() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi.set(durasi);
    }
}
