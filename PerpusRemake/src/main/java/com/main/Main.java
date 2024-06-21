package com.main;

import java.net.URL;
import com.main.UI.UIManager;
import com.main.user.Admin;
import com.main.user.Mahasiswa;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
<<<<<<< HEAD
 
    @Override
    public void start(Stage primaryStage) {
        
=======
    public static void main(String[] args) {
        addUser();
        launch(args);
    }
    public static void addUser(){
        Mahasiswa mahasiswa1 = new Mahasiswa("AGUS","202310370311080","FT","INFORMATIKA");
        Mahasiswa mahasiswa2 = new Mahasiswa("AHMAD","202310370311091","FT","INFORMATIKA");
        Mahasiswa mahasiswa3 = new Mahasiswa("Jukii","202310370311071","FT","INFORMATIKA");
        Mahasiswa mahasiswa4 = new Mahasiswa("Natsha","202310370311072","FT","INFORMATIKA");
//        Admin.getMahasiswaData().add(mahasiswa1);
//        Admin.getMahasiswaData().add(mahasiswa2);
//        Admin.getMahasiswaData().add(mahasiswa4);
//        Admin.getMahasiswaData().add(mahasiswa3);
////        Book book1 = new Book("UMM-202-301","Ilmu Hitam", "Nyi Towok",100);
////        book1.setCategory("Sejarah");
////        User.getBookList().add(book1);
////        book1.setDuration(9);
////        mahasiswa1.getBorrowedBooks().add(book1);
    }
    
    

    @Override
    public void start(Stage primaryStage)throws Exception {
>>>>>>> origin/fiture-backend
        pilihanLogin(primaryStage);
    }


    private void loginAdmin(Stage primaryStage) {
        primaryStage.setTitle("Admin Login Form");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("Welcome Admin");
        sceneTitle.setId("welcome-text");
        
        Label userName = new Label("Username:");
        userName.setId("paragraph");
        TextField userTextField = new TextField();
        userTextField.getStyleClass().add("text-field");
    
        
        Label pw = new Label("Password:");
        PasswordField pwBox = new PasswordField();
        pw.setId("paragraph");
        pwBox.getStyleClass().add("text-field");
        
        Button btn = new Button("Sign in");
        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");
        
        final Text actionTarget = new Text();
        
        // Mengatur aksi tombol Sign in
        btn.setOnAction(e -> {
            if (userTextField.getText().equals("admin") && pwBox.getText().equals("admin")) {
                try {
                    Admin admin = new Admin();
                    admin.showMenu(primaryStage);
                } catch (Exception ex) {
                    System.err.println("Error loading Admin menu: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                actionTarget.setId("action-target");
                actionTarget.setText("Invalid credentials");
            }
        });
        
        // Mengatur aksi tombol Kembali
        backButton.setOnAction(e -> pilihanLogin(primaryStage));
        
        // Mengatur tata letak komponen-komponen UI
        HBox row1 = new HBox(10);
        row1.setAlignment(Pos.CENTER);
        row1.getChildren().addAll(userName, userTextField);
        
        HBox row2 = new HBox(10);
        row2.setAlignment(Pos.CENTER);
        row2.getChildren().addAll(pw, pwBox);
        
        VBox row3 = new VBox(10);
        row3.setAlignment(Pos.CENTER);
        row3.getChildren().addAll(btn,backButton);
        
        VBox layout = new VBox(20);
        layout.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(sceneTitle, row1, row2, row3, actionTarget);
        
        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(layout, 570, 512);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        // Menampilkan stage
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }


    
private void loginMahasiswa(Stage primaryStage) {
    primaryStage.setTitle("User Login Form");

    // Membuat komponen-komponen UI
    Text sceneTitle = new Text("Selamat Datang Mahasiswa");
    sceneTitle.setId("welcome-text");

    Label nimLabel = new Label("NIM:");
    TextField nimTextField = new TextField();
    nimTextField.getStyleClass().add("text-field");

    Button btn = new Button("Login");
    btn.setId("btn-login");

    Button backButton = new Button("Kembali");
    backButton.setId("btn-outline");


    final Text actionTarget = new Text();

    // Mengatur aksi tombol Login
    btn.setOnAction(e -> {
        String nimMahasiswa = nimTextField.getText();
        Mahasiswa userMenu = new Mahasiswa(nimMahasiswa); // Inisialisasi objek UserMenu dengan NIM
        userMenu.showMenu(primaryStage); // Memanggil metode showMenu
    });

    // Mengatur aksi tombol Kembali
    backButton.setOnAction(e -> pilihanLogin(primaryStage));

    // Mengatur tata letak komponen-komponen UI
    HBox row1 = new HBox(10);
    row1.setAlignment(Pos.CENTER);
    row1.getChildren().addAll(nimLabel, nimTextField);

    VBox row2 = new VBox(10);
    row2.setAlignment(Pos.CENTER);
    row2.getChildren().addAll( btn,backButton);

    

    VBox layout = new VBox(20);
    layout.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
    layout.setAlignment(Pos.CENTER);
    layout.getChildren().addAll(sceneTitle, row1, row2, actionTarget);

    // Mengatur scene dengan layout dan CSS
    Scene scene = new Scene(layout, 570, 512);
    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

    // Menampilkan stage
    primaryStage.setScene(scene);
    primaryStage.show();

}

    public void pilihanLogin(Stage primaryStage) {
        primaryStage.setTitle("SELAMAT DATANG DI PERPUSTAKAAN");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("Pilih Login");
        sceneTitle.setId("welcome-text");

        Button adminLoginButton = new Button("Admin Login");
        Button userLoginButton = new Button("User Login");

        // Mengatur aksi tombol Admin Login
        adminLoginButton.setOnAction(e -> loginAdmin(primaryStage));
        // Mengatur aksi tombol User Login
        userLoginButton.setOnAction(e -> loginMahasiswa(primaryStage));

        // Mengatur tata letak komponen-komponen UI
        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
            sceneTitle,
            adminLoginButton,
            userLoginButton
        );

        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(layout, 570, 512);
        URL url = this.getClass().getResource("styles.css");
        if (url == null) {
            System.out.println("Resource not found. Aborting.");
            System.exit(-1);
        }
        String css = url.toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void addTempMahasiswa(Admin admin,String namaLengkap,String nimMahasiswa, String fakultasMahasiswa, String prodiMahasiswa) {
        admin.addMahasiswa(namaLengkap,nimMahasiswa,fakultasMahasiswa,prodiMahasiswa);
    }

//    public static Mahasiswa checkNIM(String namaLengkap,String nimMahasiswa, String fakultasMahasiswa, String prodiMahasiswa) {
//        for (Mahasiswa x : Admin.getMahasiswaData()) {
//            if (x.getnimMahasiswa().equals(nimMahasiswa)) {
//                return null;
//            }
//        }
//        return new Mahasiswa(namaLengkap, nimMahasiswa, fakultasMahasiswa, prodiMahasiswa);

}
