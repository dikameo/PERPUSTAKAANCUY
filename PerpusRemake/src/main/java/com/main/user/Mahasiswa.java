package com.main.user;

import java.net.URLEncoder;

import com.main.Main;
import com.main.database.Book;
import com.main.inter.MenuInterface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

public class Mahasiswa extends User implements MenuInterface  {
    private String nim;

    public Mahasiswa(String nim) {
        this.nim = nim;
    }

    @Override
    public void showMenu(Stage primaryStage) {
        primaryStage.setTitle("User Menu");

        // Membuat komponen-komponen UI
        Text sceneTitle = new Text("User Menu - NIM: " + nim);
        sceneTitle.setId("welcome-text");

        Button borrowBookButton = new Button("Pinjam Buku");

        Button tableBorrowedBooksButton = new Button("Buku yang Terpinjam");

        Button availableBooksButton = new Button("Buku yang Tersedia");

        Button userDataButton = new Button("Data User");

        Button notifikasiDendaButton = new Button("Notifikasi Denda");

        Button logoutButton = new Button("Keluar");

        // Mengatur aksi tombol-tombol
        borrowBookButton.setOnAction(e -> showBorrowBook(primaryStage));
        tableBorrowedBooksButton.setOnAction(e -> showTableBorrowedBook(primaryStage));
        availableBooksButton.setOnAction(e -> showAvailableBook(primaryStage));
        userDataButton.setOnAction(e -> showUserData(primaryStage));
        notifikasiDendaButton.setOnAction(e -> showNotifikasiDendaButton(primaryStage));
        logoutButton.setOnAction(e -> new Main().pilihanLogin(primaryStage));

        // Mengatur tata letak dengan VBox
        VBox menuLayout = new VBox(10);
        menuLayout.setPadding(new Insets(25));
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(
            sceneTitle,
            borrowBookButton,
            tableBorrowedBooksButton,
            availableBooksButton,
            userDataButton,
            notifikasiDendaButton,
            logoutButton
        );

        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(menuLayout, 570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public void showBorrowBook(Stage primaryStage){
        
        primaryStage.setTitle("Form Peminjaman");

        // Membuat komponen-komponen UI untuk Form Peminjaman
        Text sceneTitle = new Text("Silahkan Untuk meminjam buku");
        sceneTitle.setId("welcome-text");

        Label kodeLabel = new Label("Kode Buku:");
        TextField kodeTextField = new TextField();
        kodeTextField.getStyleClass().add("text-field");

        Label hariLabel = new Label("lama peminjaman hari:");
        TextField hariTextField = new TextField();
        hariTextField.getStyleClass().add("text-field");

        Button btn = new Button("Kirim");
        btn.setId("btn-login");

        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        final Text actionTarget = new Text();

        // Mengatur aksi tombol Login
        btn.setOnAction(e -> {
            System.out.println("Berhasil"); // TOMBOL AMAN
        });

        // Mengatur aksi tombol Kembali
        backButton.setOnAction(e -> showMenu(primaryStage));

        // Membuat GridPane layout untuk Form Peminjaman
        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(25, 25, 25, 25));

        // Menambahkan komponen ke GridPane untuk Form Peminjaman
        formGrid.add(sceneTitle, 0, 0, 2, 1);
        formGrid.add(kodeLabel, 0, 1);
        formGrid.add(kodeTextField, 1, 1);
        formGrid.add(hariLabel, 0, 2);
        formGrid.add(hariTextField, 1, 2);
        formGrid.add(btn, 1, 3);
        formGrid.add(backButton, 0, 3);
        formGrid.add(actionTarget, 0, 4, 2, 1);

        // Membuat komponen TableView untuk Menu Buku yang Tersedia
        TableView<Book> table = new TableView<>();

        // Kolom-kolom untuk TableView
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

        TableColumn<Book, String> lokasiColumn = new TableColumn<>("Lokasi Rak");
        lokasiColumn.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

        TableColumn<Book, String> stokColumn = new TableColumn<>("Stok");
        stokColumn.setCellValueFactory(new PropertyValueFactory<>("stok"));

        // Menambahkan kolom-kolom ke dalam TableView
        table.getColumns().addAll(noColumn, kodeBukuColumn, judulBukuColumn, penulisBukuColumn, terbitanColumn, kategoriColumn, lokasiColumn, stokColumn);

        // Membuat GridPane layout untuk Menu Buku yang Tersedia
        GridPane tableGrid = new GridPane();
        tableGrid.setAlignment(Pos.CENTER);
        tableGrid.setHgap(5);
        tableGrid.setVgap(5);
        tableGrid.setPadding(new Insets(10, 10, 10, 10));

        // Menambahkan TableView ke dalam GridPane untuk Menu Buku yang Tersedia
        tableGrid.add(table, 0, 0);

        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(new VBox(10, sceneTitle,tableGrid,formGrid), 800, 600);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());

        // Menampilkan stage
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
        penulisBukuColumn.setCellValueFactory(new PropertyValueFactory<>("penulisBuku"));

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


    public void  showTableBorrowedBook(Stage primaryStage){


          // Membuat komponen-komponen UI untuk Form Peminjaman
          Text sceneTitle = new Text("Menu kembalian buku");
          sceneTitle.setId("welcome-text");
  
          Label kodeLabel = new Label("Kode Buku yang ingin dikembalikan:");
          TextField kodeTextField = new TextField();
          kodeTextField.getStyleClass().add("text-field");
  
          Button btn = new Button("Kirim");
          btn.setId("btn-login");
  
          Button backButton = new Button("Kembali");
          backButton.setId("btn-outline");
  
          final Text actionTarget = new Text();
  
          // Mengatur aksi tombol Login
          btn.setOnAction(e -> {
              System.out.println("Berhasil"); // TOMBOL AMAN
          });
  
          // Mengatur aksi tombol Kembali
          backButton.setOnAction(e -> showMenu(primaryStage));
  
          // Membuat GridPane layout untuk Form Peminjaman
          GridPane formGrid = new GridPane();
          formGrid.setAlignment(Pos.CENTER);
          formGrid.setHgap(10);
          formGrid.setVgap(10);
          formGrid.setPadding(new Insets(25, 25, 25, 25));
  
          // Menambahkan komponen ke GridPane untuk Form Peminjaman
          formGrid.add(sceneTitle, 0, 0, 2, 1);
          formGrid.add(kodeLabel, 0, 1);
          formGrid.add(kodeTextField, 1, 1);
          formGrid.add(btn, 1, 2);
          formGrid.add(backButton, 0, 2);
          formGrid.add(actionTarget, 0, 4, 2, 1);

        primaryStage.setTitle("Menu Buku yang Terpinjam");
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
        penulisBukuColumn.setCellValueFactory(new PropertyValueFactory<>("penulisBuku"));

        // Kolom Terbitan
        TableColumn<Book, String> terbitanColumn = new TableColumn<>("Terbitan");
        terbitanColumn.setCellValueFactory(new PropertyValueFactory<>("terbitan"));

        // Kolom Kategori
        TableColumn<Book, String> kategoriColumn = new TableColumn<>("Kategori");
        kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("kategori"));


         // Kolom Kategori
         TableColumn<Book, String> durasiColumn = new TableColumn<>("Durasi");
         kategoriColumn.setCellValueFactory(new PropertyValueFactory<>("Durasi"));

        table.getColumns().addAll(noColumn, kodeBukuColumn, judulBukuColumn, penulisBukuColumn, terbitanColumn, kategoriColumn,durasiColumn);



        GridPane tableGrid = new GridPane();
        tableGrid.setAlignment(Pos.CENTER);
        tableGrid.setHgap(5);
        tableGrid.setVgap(5);
        tableGrid.setPadding(new Insets(10, 10, 10, 10));

        // Menambahkan TableView ke dalam GridPane untuk Menu Buku yang Tersedia
        tableGrid.add(table, 0, 0);

        // Mengatur scene dengan layout dan CSS
        Scene scene = new Scene(new VBox(10, sceneTitle,tableGrid,formGrid), 800, 600);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
        backButton.setOnAction(e -> showMenu(primaryStage));
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void showUserData(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Nama User:"), 0, 0);
        // grid.add(new Label(user.getNamaUser()), 1, 0);
        grid.add(new Label("Joko"), 1, 0);
        
        grid.add(new Label("Prodi:"), 0, 1);
        // grid.add(new Label(user.getProdi()), 1, 1);
        grid.add(new Label("INFORMATIKA"), 1, 1);

        grid.add(new Label("NIM:"), 0, 2);
        // grid.add(new Label(user.getNim()), 1, 2);
        grid.add(new Label("343434343"), 1, 2);

        grid.add(new Label("Fakultas:"), 0, 3);
        // grid.add(new Label(user.getFakultas()), 1, 3);
        grid.add(new Label("Komputer"), 1, 3);

        grid.add(new Label("Total Buku yang Sudah Pernah Dipinjam:"), 0, 4);
        // grid.add(new Label(String.valueOf(user.getTotalBukuDipinjam())), 1, 4);
        grid.add(new Label("20"), 1, 4);

        grid.add(new Label("Sanksi:"), 0, 5);
        // grid.add(new Label(user.getSanksi()), 1, 5);
        grid.add(new Label("0"), 1, 5);


        
        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        Main menu = new Main();
        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(grid,backButton);
        Scene scene = new Scene(vbox, 570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
        primaryStage.setTitle("Data Pengguna");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void showNotifikasiDendaButton(Stage primaryStage){
        Button dendaButton = new Button("Cek Denda");

        dendaButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Notifikasi Denda");
            alert.setHeaderText(null);
            alert.setContentText("Anda sudah melewati batas peminjaman. Silakan hubungi customer service.");

            // alert.showAndWait().ifPresent(response -> {
            //     try {
            //         String phoneNumber = "628123456789"; // Ganti dengan nomor WhatsApp customer service
            //         String message = "Halo, saya membutuhkan bantuan terkait denda peminjaman buku.";
            //         String url = "https://wa.me/" + phoneNumber + "?text=" + URLEncoder.encode(message, "UTF-8");

            //         hostServices.showDocument(url);
            //     } catch (Exception ex) {
            //         ex.printStackTrace();
            //     }
            // });
        });


        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        Main menu = new Main();
        backButton.setOnAction(e -> showMenu(primaryStage));
        VBox vbox = new VBox(dendaButton,backButton);
        
        Scene scene = new Scene(vbox, 570, 512);
        scene.getStylesheets().add(getClass().getResource("stylebaru.css").toExternalForm());
        primaryStage.setTitle("Notifikasi Denda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
