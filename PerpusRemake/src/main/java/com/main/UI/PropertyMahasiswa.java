package com.main.UI;
import javafx.beans.property.SimpleStringProperty;
import com.main.user.Mahasiswa;
import java.util.ArrayList;
public class PropertyMahasiswa {
    private final SimpleStringProperty namaLengkap;
    private final SimpleStringProperty nimMahasiswa;
    private final SimpleStringProperty prodiMahasiswa;
    private final SimpleStringProperty fakultasMahasiswa;

    public PropertyMahasiswa (String namaLengkap,String nimMahasiswa, String prodiMahasiswa, String fakultasMahasiswa){
        this.namaLengkap = new SimpleStringProperty(namaLengkap);
        this.nimMahasiswa = new SimpleStringProperty(nimMahasiswa);
        this.prodiMahasiswa = new SimpleStringProperty(prodiMahasiswa);
        this.fakultasMahasiswa = new SimpleStringProperty(fakultasMahasiswa);
    }

    public static ArrayList<PropertyMahasiswa> mahasiswaToProperty (ArrayList<Mahasiswa> arr){
        ArrayList<PropertyMahasiswa> temp = new ArrayList<>();
        for (Mahasiswa mahasiswa : arr) {
            PropertyMahasiswa obj = new PropertyMahasiswa(mahasiswa.getnamaLengkap(), mahasiswa.getnimMahasiswa(), mahasiswa.getprodiMahasiswa(), mahasiswa.getfakultasMahasiswa());
            temp.add(obj);
        }
        return temp;
    }
    public String getnamaLengkap() {
        return namaLengkap.get();
    }

    public SimpleStringProperty namaLengkapProperty() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap.set(namaLengkap);
    }

    public String getnimMahasiswa() {
        return nimMahasiswa.get();
    }

    public SimpleStringProperty nimMahasiswaProperty() {
        return nimMahasiswa;
    }

    public void setNimMahasiswa(String nimMahasiswa) {
        this.nimMahasiswa.set(nimMahasiswa);
    }

    public String getfakultasMahasiswa() {
        return fakultasMahasiswa.get();
    }

    public SimpleStringProperty facultasMahasiswaProperty() {
        return fakultasMahasiswa;
    }

    public void setfakultasMahasiswa(String fakultasMahasiswa) {
        this.fakultasMahasiswa.set(fakultasMahasiswa);
    }

    public String getprodiMahasiswa() {
        return prodiMahasiswa.get();
    }

    public SimpleStringProperty getprodiMahasiswa() {
        return prodiMahasiswa;
    }

    public void setprodiMahasiswa(String prodiMahasiswa) {
        this.prodiMahasiswa.set(prodiMahasiswa);
    }


}
