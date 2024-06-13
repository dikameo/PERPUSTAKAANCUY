package com.main.user;

import com.main.Main;
import com.main.database.Book;
import com.main.inter.MenuInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin extends User implements MenuInterface{

    @Override
    public void showMenu(Stage stage) {
        stage.setTitle("Admin Menu");

        // Membuat GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        // Menambahkan komponen ke GridPane
        Text sceneTitle = new Text("Admin Menu");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Button addStudentButton = new Button("Tambahkan Mahasiswa");
        grid.add(addStudentButton, 0, 1);

        Button addBookButton = new Button("Tambahkan Buku");
        grid.add(addBookButton, 1, 1);

        Button checkStudentButton = new Button("Cek Mahasiswa");
        grid.add(checkStudentButton, 0, 2);

        Button availableBookButton = new Button("Cek Buku");
        grid.add(availableBookButton, 1, 2);
        
        Button logoutButton = new Button("Keluar");
        grid.add(logoutButton, 0, 3);
        
        // logoutButton.setMaxSize(Double.MAX_VALUE);
        Button givePenaltyButton = new Button("Sanksi Mahasiswa");
        grid.add(givePenaltyButton, 1, 3);

        addStudentButton.setOnAction(e -> {
            showAddMahasiswa(stage);
        });

        addBookButton.setOnAction(e -> {
            showAddBook(stage);
        });

        checkStudentButton.setOnAction(e -> {
            showStudent(stage);
        });

        availableBookButton.setOnAction(e -> {
            showAvailableBook(stage);
        });


        givePenaltyButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Cek Buku clicked");
        });



        logoutButton.setOnAction(e -> new Main().pilihanLogin(stage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 570, 512);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);

        stage.show();
    }


     @Override
    public void showAvailableBook(Stage primaryStage){
        primaryStage.setTitle("Menu Buku yang Tersedia");
        TableView<Book> table = new TableView<>();

        // Kolom No
        TableColumn<Book, Integer> noColumn = new TableColumn<>("No");
        noColumn.setCellValueFactory(new PropertyValueFactory<>("no"));

        // Kolom Kode Buku
        TableColumn<Book, String> kodeBukuColumn = new TableColumn<>("Kode Buku");
        kodeBukuColumn.setCellValueFactory(new PropertyValueFactory<>("kodeBuku"));

        // Kolom Judul Buku
        TableColumn<Book, String> judulBukuColumn = new TableColumn<>("Judul Buku");
        judulBukuColumn.setCellValueFactory(new PropertyValueFactory<>("judulBuku"));

        TableColumn<Book, String> penulisBukuColumn = new TableColumn<>("Penulis Buku");
        judulBukuColumn.setCellValueFactory(new PropertyValueFactory<>("penulisBuku"));

        // Kolom Terbitan
        TableColumn<Book, String> terbitanColumn = new TableColumn<>("Terbitan");
        terbitanColumn.setCellValueFactory(new PropertyValueFactory<>("terbitan"));

        // Kolom Kategori
        TableColumn<Book, String> kategoriColumn = new TableColumn<>("Kategori");
        kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));

        // Kolom Kategori
        TableColumn<Book, String> lokasiColumn = new TableColumn<>("lokasi Rak");
        kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

         // Kolom Kategori
         TableColumn<Book, String> stokColumn = new TableColumn<>("Stok");
         kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("Stok"));

        table.getColumns().addAll(noColumn, kodeBukuColumn, judulBukuColumn, penulisBukuColumn, terbitanColumn, kategoriColumn,lokasiColumn,stokColumn);


        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

    
        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(table,backButton);
        Scene scene = new Scene(vbox,570, 512);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showStudent(Stage primaryStage){
        primaryStage.setTitle("Menu Tabel Mahasiswa");
        TableView<Mahasiswa> table = new TableView<>();

        // Kolom No
        TableColumn<Mahasiswa, Integer> noColumn = new TableColumn<>("No");
        noColumn.setCellValueFactory(new PropertyValueFactory<>("no"));

        // Kolom Kode Buku
        TableColumn<Mahasiswa, String> namaMahasiswaColumn = new TableColumn<>("Nama Mahasiswa");
        namaMahasiswaColumn.setCellValueFactory(new PropertyValueFactory<>("namaMahasiswa"));

        // Kolom Judul Buku
        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("NIM");
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> prodiColumn = new TableColumn<>("prodi");
        prodiColumn.setCellValueFactory(new PropertyValueFactory<>("prodi"));

        // Kolom Terbitan
        TableColumn<Mahasiswa, String> fakultasColumn = new TableColumn<>("fakultas");
        fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));

        // Kolom Kategori
        TableColumn<Mahasiswa, String> kategoriColumn = new TableColumn<>("Kategori");
        kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));

        // Kolom Kategori
        TableColumn<Mahasiswa, Integer> peminjamanBukuColumn = new TableColumn<>("Peminjaman Buku");
        peminjamanBukuColumn.setCellValueFactory(new PropertyValueFactory<>("peminjamanBuku"));

        TableColumn<Mahasiswa, Integer> sanksiPengguna = new TableColumn<>("Sanksi Pengguna");
        sanksiPengguna.setCellValueFactory(new PropertyValueFactory<>("sanksiPengguna"));

         // Kolom Kategori

        table.getColumns().addAll(noColumn, namaMahasiswaColumn,nimColumn, prodiColumn, fakultasColumn, kategoriColumn,peminjamanBukuColumn,sanksiPengguna);


        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        Main menu = new Main();
        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(table,backButton);
        Scene scene = new Scene(vbox,570, 512);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAddMahasiswa(Stage primaryStage){
        primaryStage.setTitle("Admin Login Form");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("Pendaftaran Mahasiswa");
        sceneTitle.setId("welcome-text");
        
        Label namaLengkap = new Label("Nama Lengkap :");
        namaLengkap.setId("paragraph");
        TextField namaTextField = new TextField();
        namaTextField.getStyleClass().add("text-field");

        Label nimMahasiswa = new Label("NIM :");
        nimMahasiswa.setId("paragraph");
        TextField nimTextField = new TextField();
        nimTextField.getStyleClass().add("text-field");

        Label prodiMahasiswa = new Label("Prodi:");
        prodiMahasiswa.setId("paragraph");
        TextField proditTextField = new TextField();
        proditTextField.getStyleClass().add("text-field");

        Label fakultasMahasiswa = new Label("Nama Fakultas :");
        fakultasMahasiswa.setId("paragraph");
        TextField fakultasTextField = new TextField();
        fakultasTextField.getStyleClass().add("text-field");
        

    

        
        Button btn = new Button("Daftarkan");
        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");
        
        final Text actionTarget = new Text();
        
        // Mengatur aksi tombol Sign in
        btn.setOnAction(e -> {
           System.out.println("Terdaftar");
        });
        
        // Mengatur aksi tombol Kembali
        backButton.setOnAction(e -> showMenu(primaryStage));
        
        // Mengatur tata letak komponen-komponen UI
        HBox row1 = new HBox(10);
        row1.setAlignment(Pos.CENTER);
        row1.getChildren().addAll(namaLengkap, namaTextField);
        
        HBox row2 = new HBox(10);
        row2.setAlignment(Pos.CENTER);
        row2.getChildren().addAll(nimMahasiswa, nimTextField);

        HBox row3 = new HBox(10);
        row3.setAlignment(Pos.CENTER);
        row3.getChildren().addAll(prodiMahasiswa, proditTextField);

        HBox row4 = new HBox(10);
        row4.setAlignment(Pos.CENTER);
        row4.getChildren().addAll(fakultasMahasiswa, fakultasTextField);
        
        VBox row5 = new VBox(10);
        row5.setAlignment(Pos.CENTER);
        row5.getChildren().addAll(btn,backButton);
        
        VBox layout = new VBox(20);
        layout.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(sceneTitle, row1, row2, row3,row4, row5, actionTarget);
        
        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(layout, 570, 512);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        // Menampilkan stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAddBook(Stage primaryStage){
            primaryStage.setTitle("Tambahkan Buku");
    
            // Membuat komponen-komponen UI
            Text sceneTitle = new Text("Pendaftaran Mahasiswa");
            sceneTitle.setId("welcome-text");
            
            Label judulBuku = new Label("Judul buku :");
            judulBuku.setId("paragraph");
            TextField judulTextField = new TextField();
            judulTextField.getStyleClass().add("text-field");
    
            Label penulisBuku = new Label("Penulis Buku :");
            penulisBuku.setId("paragraph");
            TextField penulisTextField = new TextField();
            penulisTextField.getStyleClass().add("text-field");
    
            Label terbitanBuku = new Label("Terbitan buku:");
            terbitanBuku.setId("paragraph");
            TextField terbitanBukuTextField = new TextField();
            terbitanBukuTextField.getStyleClass().add("text-field");
    
            Label kategoriBuku = new Label("kategori Buku :");
            kategoriBuku.setId("paragraph");
            TextField kategoriTextField = new TextField();
            kategoriTextField.getStyleClass().add("text-field");

            Label lokasiRak = new Label("lokasi Rak :");
            lokasiRak.setId("paragraph");
            TextField lokasiTextField = new TextField();
            lokasiTextField.getStyleClass().add("text-field");
            
            Label stok = new Label("Stock :");
            stok.setId("paragraph");
            TextField stokTextField = new TextField();
            stokTextField.getStyleClass().add("text-field");
    
        

            
            Button btn = new Button("Daftarkan");
            Button backButton = new Button("Kembali");
            backButton.setId("btn-outline");
            
            final Text actionTarget = new Text();
            
            // Mengatur aksi tombol Sign in
            btn.setOnAction(e -> {
               System.out.println("Terdaftar");
            });
            
            // Mengatur aksi tombol Kembali
            backButton.setOnAction(e -> showMenu(primaryStage));
            
            // Mengatur tata letak komponen-komponen UI
            HBox row1 = new HBox(10);
            row1.setAlignment(Pos.CENTER);
            row1.getChildren().addAll(judulBuku, judulTextField);
            
            HBox row2 = new HBox(10);
            row2.setAlignment(Pos.CENTER);
            row2.getChildren().addAll(penulisBuku, penulisTextField);
    
            HBox row3 = new HBox(10);
            row3.setAlignment(Pos.CENTER);
            row3.getChildren().addAll(terbitanBuku, terbitanBukuTextField);
    
            HBox row4 = new HBox(10);
            row4.setAlignment(Pos.CENTER);
            row4.getChildren().addAll(kategoriBuku, kategoriTextField);

            HBox row5 = new HBox(10);
            row5.setAlignment(Pos.CENTER);
            row5.getChildren().addAll(lokasiRak, lokasiTextField);

            HBox row6 = new HBox(10);
            row6.setAlignment(Pos.CENTER);
            row6.getChildren().addAll(stok, stokTextField);
            
            VBox row7 = new VBox(10);
            row7.setAlignment(Pos.CENTER);
            row7.getChildren().addAll(btn,backButton);
            
            VBox layout = new VBox(20);
            layout.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(sceneTitle, row1, row2, row3,row4, row5, row6,row7,actionTarget);
            
            // Mengatur scene dengan layout dan CSS
            Scene scene = new Scene(layout, 570, 512);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            
            // Menampilkan stage
            primaryStage.setScene(scene);
            primaryStage.show();
        
    }
}
