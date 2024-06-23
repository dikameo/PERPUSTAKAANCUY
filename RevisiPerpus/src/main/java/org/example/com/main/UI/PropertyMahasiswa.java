package org.example.com.main.UI;

import javafx.beans.property.SimpleStringProperty;
import org.example.com.main.data.Mahasiswa;
import java.util.ArrayList;

public class PropertyMahasiswa {
    private final SimpleStringProperty name;
    private final SimpleStringProperty nim;
    private final SimpleStringProperty faculty;
    private final SimpleStringProperty programStudi;
    private final SimpleStringProperty email;

    // Constructor to initialize properties
    public PropertyMahasiswa(String name, String nim, String faculty, String programStudi, String email) {
        this.name = new SimpleStringProperty(name);
        this.nim = new SimpleStringProperty(nim);
        this.faculty = new SimpleStringProperty(faculty);
        this.programStudi = new SimpleStringProperty(programStudi);
        this.email = new SimpleStringProperty(email);
    }

    // Converts a list of Mahasiswa objects to a list of PropertyMahasiswa objects
    public static ArrayList<PropertyMahasiswa> mahasiswaToProperty(ArrayList<Mahasiswa> arr) {
        ArrayList<PropertyMahasiswa> temp = new ArrayList<>();
        for (Mahasiswa mahasiswa : arr) {
            PropertyMahasiswa obj = new PropertyMahasiswa(
                mahasiswa.getName(), 
                mahasiswa.getNIM(), 
                mahasiswa.getFaculty(), 
                mahasiswa.getProgramStudi(), 
                mahasiswa.getEmail()
            );
            temp.add(obj);
        }
        return temp;
    }

    // Getters and setters for name property
    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    // Getters and setters for nim property
    public String getNim() {
        return nim.get();
    }

    public SimpleStringProperty nimProperty() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim.set(nim);
    }

    // Getters and setters for faculty property
    public String getFaculty() {
        return faculty.get();
    }

    public SimpleStringProperty facultyProperty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty.set(faculty);
    }

    // Getters and setters for programStudi property
    public String getProgramStudi() {
        return programStudi.get();
    }

    public SimpleStringProperty programStudiProperty() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi.set(programStudi);
    }

    // Getters and setters for email property
    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
