package com.main.user;

import com.main.Main;
import com.main.database.Book;
import com.main.inter.MenuInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    public void showMenu(Stage primaryStage) {
        primaryStage.setTitle("Admin Menu");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("Admin Menu");
        sceneTitle.setId("welcome-text");
        
        Button addStudentButton = new Button("Tambahkan Mahasiswa");
        addStudentButton.getStyleClass().add("menu-button");
        
        Button addBookButton = new Button("Tambahkan Buku");
        addBookButton.getStyleClass().add("menu-button");
        
        Button checkStudentButton = new Button("Cek Mahasiswa");
        checkStudentButton.getStyleClass().add("menu-button");
        
        Button availableBookButton = new Button("Cek Buku");
        availableBookButton.getStyleClass().add("menu-button");
        
        Button givePenaltyButton = new Button("Sanksi Mahasiswa");
        givePenaltyButton.getStyleClass().add("menu-button");
        
        Button logoutButton = new Button("Keluar");
        logoutButton.getStyleClass().add("menu-button");
        
        // Mengatur aksi tombol-tombol
        addStudentButton.setOnAction(e -> showAddMahasiswa(primaryStage));
        addBookButton.setOnAction(e -> showAddBook(primaryStage));
        checkStudentButton.setOnAction(e -> showStudent(primaryStage));
        availableBookButton.setOnAction(e -> showAvailableBook(primaryStage));
        givePenaltyButton.setOnAction(e -> showSanksiStudent(primaryStage));
        logoutButton.setOnAction(e -> new Main().pilihanLogin(primaryStage));
        
        // Mengatur tata letak dengan VBox
        VBox menuLayout = new VBox(10);
        menuLayout.setPadding(new Insets(25));
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(
            sceneTitle,
            addStudentButton,
            addBookButton,
            checkStudentButton,
            availableBookButton,
            givePenaltyButton,
            logoutButton
        );
        
        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(menuLayout, 570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
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
        lokasiColumn.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

         // Kolom Kategori
         TableColumn<Book, String> stokColumn = new TableColumn<>("Stok");
         stokColumn.setCellValueFactory(new PropertyValueFactory<>("Stok"));

        table.getColumns().addAll(noColumn, kodeBukuColumn, judulBukuColumn, penulisBukuColumn, terbitanColumn, kategoriColumn,lokasiColumn,stokColumn);


        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

    
        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(table,backButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox,570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
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

        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(table,backButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox,570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAddMahasiswa(Stage primaryStage){
        primaryStage.setTitle("Pendaftaran Mahasiswa");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("Pendaftaran Mahasiswa");
        sceneTitle.setId("welcome-text");

        Label namaLengkap = new Label("Nama Lengkap:");
        namaLengkap.setId("paragraph");
        TextField namaTextField = new TextField();
        namaTextField.getStyleClass().add("text-field");

        Label nimMahasiswa = new Label("NIM:");
        nimMahasiswa.setId("paragraph");
        TextField nimTextField = new TextField();
        nimTextField.getStyleClass().add("text-field");

        Label prodiMahasiswa = new Label("Prodi:");
        prodiMahasiswa.setId("paragraph");
        TextField proditTextField = new TextField();
        proditTextField.getStyleClass().add("text-field");

        Label fakultasMahasiswa = new Label("Nama Fakultas:");
        fakultasMahasiswa.setId("paragraph");
        TextField fakultasTextField = new TextField();
        fakultasTextField.getStyleClass().add("text-field");

        Button btn = new Button("Daftarkan");
        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        final Text actionTarget = new Text();

        // Mengatur aksi tombol Daftarkan
        btn.setOnAction(e -> {
            System.out.println("Terdaftar");
        });

        // Mengatur aksi tombol Kembali
        backButton.setOnAction(e -> showMenu(primaryStage));

        // Mengatur tata letak komponen-komponen UI dengan GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(sceneTitle, 0, 0, 2, 1);

        grid.add(namaLengkap, 0, 1);
        grid.add(namaTextField, 1, 1);

        grid.add(nimMahasiswa, 0, 2);
        grid.add(nimTextField, 1, 2);

        grid.add(prodiMahasiswa, 0, 3);
        grid.add(proditTextField, 1, 3);

        grid.add(fakultasMahasiswa, 0, 4);
        grid.add(fakultasTextField, 1, 4);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().addAll(backButton,btn);
        grid.add(hbBtn, 1, 5);

        grid.add(actionTarget, 1, 6);

        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(grid, 570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());

        // Menampilkan stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAddBook(Stage primaryStage){
        primaryStage.setTitle("Tambahkan Buku");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("Tambahkan Buku");
        sceneTitle.setId("welcome-text");

        Label judulBuku = new Label("Judul Buku:");
        judulBuku.setId("paragraph");
        TextField judulTextField = new TextField();
        judulTextField.getStyleClass().add("text-field");

        Label penulisBuku = new Label("Penulis Buku:");
        penulisBuku.setId("paragraph");
        TextField penulisTextField = new TextField();
        penulisTextField.getStyleClass().add("text-field");

        Label terbitanBuku = new Label("Terbitan Buku:");
        terbitanBuku.setId("paragraph");
        DatePicker terbitanBukuDatePicker = new DatePicker();
        terbitanBukuDatePicker.getStyleClass().add("text-field");

        Label kategoriBuku = new Label("Kategori Buku:");
        kategoriBuku.setId("paragraph");
        ComboBox<String> kategoriComboBox = new ComboBox<>();
        kategoriComboBox.getItems().addAll(
            "Fiksi", 
            "Non-Fiksi", 
            "Teknologi", 
            "Sains", 
            "Sejarah"
        );
        kategoriComboBox.getStyleClass().add("text-field");

        Label lokasiRak = new Label("Lokasi Rak:");
        lokasiRak.setId("paragraph");
        TextField lokasiTextField = new TextField();
        lokasiTextField.getStyleClass().add("text-field");

        Label stok = new Label("Stok:");
        stok.setId("paragraph");
        TextField stokTextField = new TextField();
        stokTextField.getStyleClass().add("text-field");

        Button btn = new Button("Daftarkan");
        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        final Text actionTarget = new Text();

        // Mengatur aksi tombol Daftarkan
        btn.setOnAction(e -> {
            System.out.println("Terdaftar");
        });

        // Mengatur aksi tombol Kembali
        backButton.setOnAction(e -> showMenu(primaryStage));

        // Mengatur tata letak komponen-komponen UI dengan GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(sceneTitle, 0, 0, 2, 1);

        grid.add(judulBuku, 0, 1);
        grid.add(judulTextField, 1, 1);

        grid.add(penulisBuku, 0, 2);
        grid.add(penulisTextField, 1, 2);

        grid.add(terbitanBuku, 0, 3);
        grid.add(terbitanBukuDatePicker, 1, 3);

        grid.add(kategoriBuku, 0, 4);
        grid.add(kategoriComboBox, 1, 4);

        grid.add(lokasiRak, 0, 5);
        grid.add(lokasiTextField, 1, 5);

        grid.add(stok, 0, 6);
        grid.add(stokTextField, 1, 6);

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().addAll( backButton,btn);
        grid.add(hbBtn, 1, 7);

        grid.add(actionTarget, 1, 8);

        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(grid, 570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());

        // Menampilkan stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void showSanksiStudent(Stage primaryStage){
        
           Text sceneTitle = new Text("Berikan sanksi");
           sceneTitle.setId("welcome-text");
   
           Label kodeLabel = new Label("Kode Buku yang ingin terlambat:");
           TextField kodeTextField = new TextField();
           kodeTextField.getStyleClass().add("text-field");
   
           Button btn = new Button("Kirim");
           btn.setId("btn-login");
   
           Button backButton = new Button("Kembali");
           backButton.setId("btn-outline");
   
           final Text actionTarget = new Text();
   
           btn.setOnAction(e -> {
               System.out.println("Berhasil"); 
           });
   
          
           backButton.setOnAction(e -> showMenu(primaryStage));
   
           GridPane formGrid = new GridPane();
           formGrid.setAlignment(Pos.CENTER);
           formGrid.setHgap(10);
           formGrid.setVgap(10);
           formGrid.setPadding(new Insets(25, 25, 25, 25));
   
           
           formGrid.add(sceneTitle, 0, 0, 2, 1);
           formGrid.add(kodeLabel, 0, 1);
           formGrid.add(kodeTextField, 1, 1);
           formGrid.add(btn, 1, 2);
           formGrid.add(backButton, 0, 2);
           formGrid.add(actionTarget, 0, 4, 2, 1);
 
         primaryStage.setTitle("Berikan sanksi pada peminjaman");
         TableView<Book> table = new TableView<>();
 
      
         TableColumn<Book, Integer> noColumn = new TableColumn<>("No");
         noColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
 
       
         TableColumn<Book, String> kodeBukuColumn = new TableColumn<>("Kode Buku");
         kodeBukuColumn.setCellValueFactory(new PropertyValueFactory<>("kodeBuku"));
 
     
         TableColumn<Book, String> judulBukuColumn = new TableColumn<>("Judul Buku");
         judulBukuColumn.setCellValueFactory(new PropertyValueFactory<>("judulBuku"));
 
         TableColumn<Book, String> penulisBukuColumn = new TableColumn<>("Penulis Buku");
         penulisBukuColumn.setCellValueFactory(new PropertyValueFactory<>("penulisBuku"));
 
      
         TableColumn<Book, String> terbitanColumn = new TableColumn<>("Terbitan");
         terbitanColumn.setCellValueFactory(new PropertyValueFactory<>("terbitan"));
 
      
         TableColumn<Book, String> kategoriColumn = new TableColumn<>("Kategori");
         kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));
 
 
          // Kolom Kategori
          TableColumn<Book, String> durasiColumn = new TableColumn<>("Durasi");
          durasiColumn.setCellValueFactory(new PropertyValueFactory<>("Durasi"));
 
         table.getColumns().addAll(noColumn, kodeBukuColumn, judulBukuColumn, penulisBukuColumn, terbitanColumn, kategoriColumn,durasiColumn);
 
 
 
         GridPane tableGrid = new GridPane();
         tableGrid.setAlignment(Pos.CENTER);
         tableGrid.setHgap(5);
         tableGrid.setVgap(5);
         tableGrid.setPadding(new Insets(10, 10, 10, 10));
 
         
         tableGrid.add(table, 0, 0);
 
       
         Scene scene = new Scene(new VBox(10, sceneTitle,tableGrid,formGrid), 800, 600);
         scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
         backButton.setOnAction(e -> showMenu(primaryStage));
         primaryStage.setScene(scene);
         primaryStage.show();
    }

    
}
