package com.main.user;

import java.net.URLEncoder;

import com.main.Main;
import com.main.database.Book;
import com.main.inter.MenuInterface;

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

        // Membuat GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        // Menambahkan komponen ke GridPane
        Text sceneTitle = new Text("User Menu - NIM: " + nim);
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Button borrowBookButton = new Button("Pinjam Buku");
        grid.add(borrowBookButton, 0, 1);

        Button tableBorrowedBooksButton = new Button("Buku yang Terpinjam");
        grid.add(tableBorrowedBooksButton, 1, 1);

        Button availableBooksButton = new Button("Buku yang Tersedia");
        grid.add(availableBooksButton, 0, 2);

        Button userDataButton = new Button("Data User");
        grid.add(userDataButton, 1, 2);

        Button notifikasiDendaButton = new Button("Notifikasi Denda");
        grid.add(notifikasiDendaButton, 0, 3);

        Button logoutButton = new Button("Keluar");
        grid.add(logoutButton, 1, 3);

        borrowBookButton.setOnAction(e -> {
            showBorrowBook(primaryStage);
        });

        tableBorrowedBooksButton.setOnAction(e -> {
           showTableBorrowedBook(primaryStage);
        });

        availableBooksButton.setOnAction(e -> {
            showAvailableBook(primaryStage);
        });

        userDataButton.setOnAction(e -> {
            showUserData(primaryStage);
        });

        notifikasiDendaButton.setOnAction(e -> {
            showNotifikasiDendaButton(primaryStage);
        });

        logoutButton.setOnAction(e -> new Main().pilihanLogin(primaryStage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 570, 512);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void showBorrowBook(Stage primaryStage){
    primaryStage.setTitle("Form Peminjaman");

    // Membuat komponen-komponen UI
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



    HBox row1 = new HBox(10);
    row1.setAlignment(Pos.CENTER);
    row1.getChildren().addAll(kodeLabel, kodeTextField);
    
    HBox row2 = new HBox(10);
    row2.setAlignment(Pos.CENTER);
    row2.getChildren().addAll(hariLabel, hariTextField);
    
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

        Main menu = new Main();
        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(table,backButton);
        Scene scene = new Scene(vbox,570, 512);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void  showTableBorrowedBook(Stage primaryStage){
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


        Button backButton = new Button("Kembali");
        backButton.setId("btn-outline");

        Main menu = new Main();
        backButton.setOnAction(e -> showMenu(primaryStage));

        VBox vbox = new VBox(table,backButton);
        Scene scene = new Scene(vbox,570, 512);
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

        primaryStage.setTitle("Notifikasi Denda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
