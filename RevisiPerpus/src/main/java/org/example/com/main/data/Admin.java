package org.example.com.main.data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.com.main.Main;
import org.example.com.main.UI.PropertyBook;
import org.example.com.main.UI.PropertyMahasiswa;
import org.example.com.main.UI.UIManager;
import org.example.com.main.books.*;
import org.example.com.main.util.IMenu;
import org.example.com.main.exception.illegalAdminAcces;

import java.io.IOException;
import java.util.*;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Admin extends User implements IMenu {
    private TableView tableMahasiswa = new TableView<>();
    private final String adminUserName = "admin";
    private final String adminPassword = "admin";
    private static final ArrayList<Mahasiswa> MAHASISWA_DATA = new ArrayList<>();
    private static final ArrayList<String> mahasiswaList = new ArrayList<>();

    public static void logIn(Stage stage) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("Log In Admin");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

        Label userName = new Label("Username:");
        grid.add(userName, 1, 1); // Kolom 0, Baris 1

        TextField inputUserName = new TextField();
        inputUserName.setPromptText("Enter your username");
        grid.add(inputUserName, 1, 2); // Kolom 1, Baris 1

        Label password = new Label("Password : ");
        grid.add(password, 1, 3);

        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Enter your password");
        grid.add(inputPassword, 1, 4);

        Button btnSignIn = new Button("SIGN IN");
        Button btnBack = new Button("BACK");
        HBox hBBtn = new HBox(10);
        hBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBBtn.getChildren().addAll(btnBack, btnSignIn);
        grid.add(hBBtn, 1, 5);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 6);

        btnSignIn.setOnAction(actionEvent -> {
            if (inputUserName.getText().isEmpty() || inputPassword.getText().isEmpty()) {
                UIManager.showError(actionTarget, "Username or password cannot be empty");
            } else {
                Admin admin = new Admin();
                try {
                    boolean isValid = admin.isAdmin(inputUserName.getText(), inputPassword.getText());
                    admin.menu(stage);
                } catch (illegalAdminAcces e) {
                    UIManager.showError(actionTarget, e.getMessage());
                }
            }
        });

        btnBack.setOnAction(actionEvent -> {
            stage.setScene(UIManager.getPreviousLayout());
        });

        Scene scene = new Scene(grid, 820, 420);
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setTitle("LOGIN ADMIN");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void menu(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("Admin Menu");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

    
        Button btnaddMahasiswa = new Button("Tambahkan data Mahasiswa");
        Button btnAddBook = new Button("Tambahkan Buku Baru");
        Button btnDisplayMahasiswa = new Button("Tampilkan Daftar Mahasiswa");
        Button btnDisplayBook = new Button("Tampilkan Daftar Buku");
        Button btnEditBook = new Button("Ubah Buku");
        Button btnPinjamB = new Button("Pinjam Buku");
        Button btnKembalikanB = new Button("Kembalikan Buku");
        Button btnUpBook = new Button("Update Peminjaman Buku");
        Button btnDenda = new Button("Denda Buku");
        Button btnLogOut = new Button("Keluar");

        double width = 50; 
        double height = 50;
        VBox conAddMahasiswa = new VBox(10);
        Label labelAddMahasiswa = new Label("Gunakan menu ini untuk \nmenambahkan mahasiswa");
        labelAddMahasiswa.setId("paragraph");
        conAddMahasiswa.setAlignment(Pos.CENTER);
        ImageView imageViewStudent = new ImageView(new Image(Main.class.getResourceAsStream("img/student.png")));
        imageViewStudent.setFitWidth(width);
        imageViewStudent.setFitHeight(height);
        conAddMahasiswa.getChildren().addAll(imageViewStudent,labelAddMahasiswa,btnaddMahasiswa);
        grid.add(conAddMahasiswa,1,3);


        VBox conAddBook = new VBox(10);
        Label labelAddBook = new Label("Gunakan menu ini untuk \nmenambahkan Buku");
        labelAddBook.setId("paragraph");
        conAddBook.setAlignment(Pos.CENTER);
        ImageView imageViewAddBook = new ImageView(new Image(Main.class.getResourceAsStream("img/Buku.png")));
        imageViewAddBook.setFitWidth(width);
        imageViewAddBook.setFitHeight(height);
        btnAddBook.getStyleClass().add("btnMenu");
        conAddBook.getChildren().addAll(imageViewAddBook,labelAddBook,btnAddBook);
        grid.add(conAddBook,2,3);


        VBox conDisplayMahasiswa = new VBox(10);
        Label labelDisplayMahasiswa = new Label("Gunakan menu ini untuk \nmenampilkan mahasiswa");
        labelDisplayMahasiswa.setId("paragraph");
        conDisplayMahasiswa.setAlignment(Pos.CENTER);
        ImageView imageViewDisplayMahasiswa = new ImageView(new Image(Main.class.getResourceAsStream("img/User.png")));
        imageViewDisplayMahasiswa.setFitWidth(width);
        imageViewDisplayMahasiswa.setFitHeight(height);
        btnAddBook.getStyleClass().add("btnMenu");
        conDisplayMahasiswa.getChildren().addAll(imageViewDisplayMahasiswa,labelDisplayMahasiswa,btnDisplayMahasiswa);
        grid.add(conDisplayMahasiswa,3,3);

        
        VBox conDisplayBook = new VBox(10);
        Label labelDisplayBook = new Label("Gunakan menu ini untuk \ndisplay book");
        labelDisplayBook.setId("paragraph");
        conDisplayBook.setAlignment(Pos.CENTER);
        ImageView imageViewDisplayBook = new ImageView(new Image(Main.class.getResourceAsStream("img/ViewBuku.png")));
        imageViewDisplayBook.setFitWidth(width);
        imageViewDisplayBook.setFitHeight(height);
        btnAddBook.getStyleClass().add("btnMenu");
        conDisplayBook.getChildren().addAll(imageViewDisplayBook,labelDisplayBook,btnDisplayBook);
        grid.add(conDisplayBook,4,3);

        VBox conEditBook = new VBox(10);
        Label labelEditBook = new Label("Gunakan menu ini untuk \nmenambahkan mahasiswa");
        labelEditBook.setId("paragraph");
        conEditBook.setAlignment(Pos.CENTER);
        ImageView imageEditBook = new ImageView(new Image(Main.class.getResourceAsStream("img/Update.png")));
        imageEditBook.setFitWidth(width);
        imageEditBook.setFitHeight(height);
        btnAddBook.getStyleClass().add("btnMenu");
        conEditBook.getChildren().addAll(imageEditBook,labelEditBook,btnEditBook);
        grid.add(conEditBook,1,4);


        VBox conPinjamBuku = new VBox(10);
        Label labelPinjamB = new Label("Gunakan menu ini untuk \n    melakukan peminjaman");
        labelPinjamB.setId("paragraph");
        conPinjamBuku.setAlignment(Pos.CENTER);
        ImageView imgPinjamB = new ImageView(new Image(Main.class.getResourceAsStream("img/Pinjam.png")));
        imgPinjamB.setFitWidth(width);
        imgPinjamB.setFitHeight(height);
        conPinjamBuku.getChildren().addAll(imgPinjamB,labelPinjamB,btnPinjamB);
        grid.add(conPinjamBuku,2,4);

        VBox conKembalikanB = new VBox(10);
        Label labelKembalikanB = new Label("Gunakan menu ini untuk \n  mengembalikan buku");
        labelKembalikanB.setId("paragraph");
        conKembalikanB.setAlignment(Pos.CENTER);
        ImageView imgKembalikanB = new ImageView(new Image(Main.class.getResourceAsStream("img/Kembali.png")));
        imgKembalikanB.setFitWidth(width);
        imgKembalikanB.setFitHeight(height);

        conKembalikanB.getChildren().addAll(imgKembalikanB,labelKembalikanB,btnKembalikanB);
        grid.add(conKembalikanB,3,4);


        VBox conUpdateBuku = new VBox(10);
        Label labelUpdateBuku = new Label("Gunakan menu ini untuk \n    meng-udapte buku");
        labelUpdateBuku.setId("paragraph");
        conUpdateBuku.setAlignment(Pos.CENTER);
        ImageView imgUpdateBuku = new ImageView(new Image(Main.class.getResourceAsStream("img/Update.png")));
        imgUpdateBuku.setFitWidth(width);
        imgUpdateBuku.setFitHeight(height);
        conUpdateBuku.getChildren().addAll(imgUpdateBuku,labelUpdateBuku,btnUpBook);
        grid.add(conUpdateBuku,4,4);

        VBox conDenda = new VBox(10);
        Label labelDenda = new Label("Gunakan menu ini untuk \n   Keluar dari menu");
        labelDenda.setId("paragraph");
        conDenda.setAlignment(Pos.CENTER);
        ImageView imgDenda = new ImageView(new Image(Main.class.getResourceAsStream("img/Denda.png")));
        imgDenda.setFitWidth(width);
        imgDenda.setFitHeight(height);
        conDenda.getChildren().addAll(imgDenda,labelDenda,btnDenda);
        grid.add(conDenda,1,5);



        VBox conLogout = new VBox(10);
        Label labelLogout = new Label("Gunakan menu ini untuk \nmenambahkan mahasiswa");
        labelLogout.setId("paragraph");
        conLogout.setAlignment(Pos.CENTER);
        ImageView imageLogout = new ImageView(new Image(Main.class.getResourceAsStream("img/Kembali.png")));
        imageLogout.setFitWidth(width);
        imageLogout.setFitHeight(height);
        btnAddBook.getStyleClass().add("btnMenu");
        conLogout.getChildren().addAll(imageLogout,labelLogout,btnLogOut);
        grid.add(conLogout,2,5);


       

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 4);

        

        btnPinjamB.setOnAction(actionEvent -> {
            // this.pinjamBuku(stage);
            System.out.println("PINJAM JALAN");
        });

        
        btnKembalikanB.setOnAction(actionEvent -> {
            // this.pinjamBuku(stage);
            System.out.println("KEMBALIKAN JALAN");
        });

        btnUpBook.setOnAction(actionEvent -> {
            // this.pinjamBuku(stage);
            System.out.println("UP JALAN");
        });

        btnDenda.setOnAction(actionEvent -> {
            // this.pinjamBuku(stage);
            System.out.println("Denda JALAN");
        });
        btnaddMahasiswa.setOnAction(actionEvent -> {
            try {
                addMahasiswa(stage);
            } catch (Exception e) {
                UIManager.showError(actionTarget, e.getMessage());
            }
            
        });

        btnAddBook.setOnAction(actionEvent -> {
            try {
                inputBook(stage);
            } catch (Exception e) {
                UIManager.showError(actionTarget, e.getMessage());
            }
        });

        btnDisplayBook.setOnAction(actionEvent -> {
            try {
                displayBook(stage);
            } catch (Exception e) {
                UIManager.showError(actionTarget, e.getMessage());
            }
        });

        btnDisplayMahasiswa.setOnAction(actionEvent -> {
            try {
                displayMahasiswa(stage);
            } catch (Exception e) {
                UIManager.showError(actionTarget, e.getMessage());
            }
        });

        btnLogOut.setOnAction(actionEvent -> {
            logOut(stage);
        });

        btnEditBook.setOnAction(actionEvent -> {
            updateBooks(stage);
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setTitle("ADMIN MENU");
        stage.setScene(scene);
        stage.show();
    }

    public void addMahasiswa(Stage stage) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("Add Mahasiswa");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

        Label name = new Label("Nama");
        grid.add(name, 0, 1); // Kolom 0, Baris 1
        TextField inputName = new TextField();
        inputName.setPromptText("Enter mahasiswa name");
        grid.add(inputName, 1, 1); // Kolom 1, Baris 1

        Label NIM = new Label("NIM  ");
        grid.add(NIM, 0, 2);
        TextField inputNIM = new TextField();
        inputNIM.setPromptText("Enter mahasiswa NIM");
        grid.add(inputNIM, 1, 2);

        Label faculty = new Label("Fakultas");
        grid.add(faculty, 0, 3);
        TextField inputFaculty = new TextField();
        inputFaculty.setPromptText("Enter mahasiswa faculty");
        grid.add(inputFaculty, 1, 3);

        Label program = new Label("Program Studi");
        grid.add(program, 0, 4);
        TextField inputProgram = new TextField();
        inputProgram.setPromptText("Enter mahasiswa program");
        grid.add(inputProgram, 1, 4);

        Button btnSubmit = new Button("SUBMIT");
        Button btnBack = new Button("BACK");
        HBox hBBtn = new HBox(10);
        hBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBBtn.getChildren().addAll(btnBack, btnSubmit);
        grid.add(hBBtn, 1, 5);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 6);

        btnSubmit.setOnAction(actionEvent -> {
            Mahasiswa mahasiswa = Main.checkNIM(inputName.getText(), inputNIM.getText(), inputFaculty.getText(),
                    inputProgram.getText());
            if (inputName.getText().isEmpty() || inputNIM.getText().isEmpty() || inputFaculty.getText().isEmpty()
                    || inputProgram.getText().isEmpty())
                UIManager.showError(actionTarget, "PLEASE FILL ALL BLANKS");
            else if (mahasiswa == null)
                UIManager.showError(actionTarget, "NIM SAME");
            else {
                Main.addTempMahasiswa(this, inputName.getText(), inputNIM.getText(), inputFaculty.getText(),
                        inputProgram.getText());
                UIManager.showSuccess(actionTarget, "MAHASISWA ADDED SUCCESSFULY");
            }
        });

        btnBack.setOnAction(actionEvent -> {
            stage.setScene(UIManager.getPreviousLayout());
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());
        stage.setTitle("ADD Mahasiswa MENU");
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    public void displayMahasiswa(Stage stage) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        tableMahasiswa.setEditable(true);

        tableMahasiswa.getColumns().clear();
        TableColumn<Mahasiswa, String> nameCol = new TableColumn<>("Name");
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        TableColumn<Mahasiswa, String> facultyCol = new TableColumn<>("Faculty");
        TableColumn<Mahasiswa, String> prodiCol = new TableColumn<>("Program Studi");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));
        facultyCol.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        prodiCol.setCellValueFactory(new PropertyValueFactory<>("programStudi"));
        tableMahasiswa.getColumns().addAll(nameCol, nimCol, facultyCol, prodiCol);


        nameCol.setPrefWidth(148);
        nimCol.setPrefWidth(148);
        facultyCol.setPrefWidth(148);
        prodiCol.setPrefWidth(148);
        
        Button backBtn = new Button("Back");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Add VBox with table and label to the GridPane
        gridPane.add(tableMahasiswa, 0, 0,5,1);

        // Add button to GridPane at bottom right
        GridPane.setHalignment(backBtn, HPos.RIGHT);
        gridPane.add(backBtn, 0, 1);

        // Create and set the scene
        Scene scene = new Scene(gridPane, UIManager.getWidth(), UIManager.getHeight());
        ArrayList<PropertyMahasiswa> convertMahasiswa = PropertyMahasiswa.mahasiswaToProperty(Admin.getMahasiswaData());
        final ObservableList<PropertyMahasiswa> data = FXCollections.observableArrayList(convertMahasiswa);

        backBtn.setOnAction(e -> {
            stage.setScene(UIManager.getPreviousLayout());
        });

        tableMahasiswa.setItems(data);
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("TABLE REGISTERED Mahasiswa");
        stage.show();
    }

    public void inputBook(Stage stage) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("Add Book");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

        Label categoryLabel = new Label("Category:");
        grid.add(categoryLabel, 0, 1);

        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Manajemen", "Novel","Ekonomi","Hukum","Sejarah","Agama","Psikologi","Teknologi");
        categoryComboBox.setPromptText("Select category");
        grid.add(categoryComboBox, 1, 1);

        Label title = new Label("Title :");
        grid.add(title, 0, 2); // Kolom 0, Baris 1
        TextField fieldTitle = new TextField();
        fieldTitle.setPromptText("Enter book title");
        grid.add(fieldTitle, 1, 2); // Kolom 1, Baris 1

        Label author = new Label("Author : ");
        grid.add(author, 0, 3);
        TextField fieldAuthor = new TextField();
        fieldAuthor.setPromptText("Enter book author");
        grid.add(fieldAuthor, 1, 3);

        Label stock = new Label("Stock");
        grid.add(stock, 0, 4);
        TextField fieldStock = new TextField();
        fieldStock.setPromptText("Enter book stock");
        grid.add(fieldStock, 1, 4);

        Button btnSubmit = new Button("SUBMIT");
        Button btnBack = new Button("BACK");
        HBox hBBtn = new HBox(10);
        hBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBBtn.getChildren().addAll(btnBack, btnSubmit);
        grid.add(hBBtn, 1, 5);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 6);

        btnSubmit.setOnAction(actionEvent -> {
            String categoryValue = categoryComboBox.getValue();
            if (categoryValue == null || fieldAuthor.getText().isEmpty() || fieldTitle.getText().isEmpty()
                    || fieldStock.getText().isEmpty())
                UIManager.showError(actionTarget, "PLEASE FILL ALL BLANKS");
            else {
                try {
                    Book book;
                    if (categoryValue.equals("Fiksi"))
                        book = new Fiksi(this.generateId(), fieldTitle.getText(), fieldAuthor.getText(),
                                Integer.parseInt(fieldStock.getText()));
                    else if (categoryValue.equals("Sejarah"))
                        book = new Sejarah(this.generateId(), fieldTitle.getText(), fieldAuthor.getText(),
                                Integer.parseInt(fieldStock.getText()));
                    else if (categoryValue.equals("NonFiksi"))
                        book = new NonFiksi(this.generateId(), fieldTitle.getText(), fieldAuthor.getText(),
                                Integer.parseInt(fieldStock.getText()));
                    else if (categoryValue.equals("Teknologi"))
                        book = new Teknologi(this.generateId(), fieldTitle.getText(), fieldAuthor.getText(),
                                Integer.parseInt(fieldStock.getText()));
                    else if (categoryValue.equals("Sains"))
                        book = new Sains(this.generateId(), fieldTitle.getText(), fieldAuthor.getText(),
                                Integer.parseInt(fieldStock.getText()));
                    else
                        book = new StoryBook(this.generateId(), fieldTitle.getText(), fieldAuthor.getText(),
                                Integer.parseInt(fieldStock.getText()));
                    super.addBook(book);
                    UIManager.showSuccess(actionTarget, "BOOK SUCESSFLY ADDED");
                } catch (Exception e) {
                    UIManager.showError(actionTarget, e.getMessage());
                }
            }
        });

        btnBack.setOnAction(actionEvent -> {
            stage.setScene(UIManager.getPreviousLayout());
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setTitle("ADD BOOK MENU");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void updateBooks(Stage stage) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("EDIT BOOK");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

        TableView<PropertyBook> table = createTableView(getBookList());
        table.getColumns().forEach(column -> {
            column.setPrefWidth(148);
        });
        grid.add(table, 0, 1, 5, 1);

        Label note = new Label("Masukkan ID buku yang tersedia pada tabel diatas");
        TextField fieldId = new TextField();
        fieldId.setPromptText("Enter book Id");
        grid.add(note,0,2,5,1);
        grid.add(fieldId,0,3,5,1);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 0, 4,4,1);

        HBox hBBtn = new HBox(10);
        Button btnReturn = new Button("EDIT BOOK INFORMATION");
        Button btnBack = new Button("BACK");
        hBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBBtn.getChildren().addAll(btnBack, btnReturn);
        grid.add(hBBtn, 0, 5);

        btnReturn.setOnAction(actionEvent -> {
            if (fieldId.getText().isEmpty()) {
                UIManager.showError(actionTarget, "FIELD CANNOT BE EMPTY");
                return;
            }
            Book book = this.searchBookAll(fieldId.getText());
            if (book == null) {
                UIManager.showError(actionTarget, "Book with id " + fieldId.getText() + " is not found");
            } else {
                changeBook(stage, book);
            }
        });

        btnBack.setOnAction(actionEvent -> {
            stage.close();
            menu(stage);
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setTitle("EDIT BOOK MEMU");
        stage.setScene(scene);
        stage.show();
    }

    public void displayBook(Stage stage) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("AVAILABLE BOOKS");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

        TableView<PropertyBook> table = super.createTableView(getBookList());
       
        // TableView<PropertyBook> table = createTableView(this.getBorrowedBooks());
        table.getColumns().forEach(column -> {
            column.setPrefWidth(148);
        });
        grid.add(table, 0, 1, 5, 1); // Menambahkan TableView ke GridPane

        HBox hBBtn = new HBox(10);
        Button btnBack = new Button("BACK");
        hBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBBtn.getChildren().addAll(btnBack);
        grid.add(hBBtn, 1, 2);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 3);

        btnBack.setOnAction(e -> {
            stage.close();
            menu(stage);
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setTitle("DISPLAY AVAILABE BOOKS");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void logOut(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("YOU ARE LOGOUT FROM ADMIN");

        ButtonType yesButton = new ButtonType("OK");
        alert.getButtonTypes().setAll(yesButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            stage.close();
            try {
                Main.menu(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void changeBook(Stage stage, Book book) {
        UIManager.setPreviousLayout(stage.getScene());// SAVE PRVIOUS SCENE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Jarak horizontal antar kolom
        grid.setVgap(10); // Jarak vertikal antar baris
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("Add Book");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Kolom 0, Baris 0, Colspan 2, Rowspan 1

        Label categoryLabel = new Label("Category:");
        grid.add(categoryLabel, 0, 1);

        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Sejarah","Story","Fiksi","NonFiksi","Sains","Teknologi");
        categoryComboBox.setPromptText("Select category");
        grid.add(categoryComboBox, 1, 1);

        Label title = new Label("Title :");
        grid.add(title, 0, 2); // Kolom 0, Baris 1
        TextField fieldTitle = new TextField();
        
        fieldTitle.setText(book.getTitle());
        grid.add(fieldTitle, 1, 2); // Kolom 1, Baris 1

        Label author = new Label("Author : ");
        grid.add(author, 0, 3);
        TextField fieldAuthor = new TextField();
        fieldAuthor.setText(book.getAuthor());
        grid.add(fieldAuthor, 1, 3);

        Label stock = new Label("Stock");
        grid.add(stock, 0, 4);
        TextField fieldStock = new TextField();
        fieldStock.setText(String.valueOf(book.getStock()));
        // fieldStock.setPromptText("Enter book stock");
        grid.add(fieldStock, 1, 4);

        Button btnSubmit = new Button("SAVE");
        Button btnBack = new Button("BACK");
        HBox hBBtn = new HBox(10);
        hBBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBBtn.getChildren().addAll(btnBack, btnSubmit);
        grid.add(hBBtn, 1, 5);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 6);

        btnSubmit.setOnAction(actionEvent -> {
            String categoryValue = categoryComboBox.getValue();
            if (categoryValue == null || fieldAuthor.getText().isEmpty() || fieldTitle.getText().isEmpty()
                    || fieldStock.getText().isEmpty())
                UIManager.showError(actionTarget, "PLEASE FILL ALL BLANKS");
            else {
                try {
                    book.setTitle(fieldTitle.getText());
                    book.setAuthor(fieldAuthor.getText());
                    book.setStock(Integer.parseInt(fieldStock.getText()));
                    book.setCategory(categoryValue);
                    UIManager.showSuccess(actionTarget, "BOOK SUCESSFLY ADDED");
                    stage.close();
                    menu(stage);
                } catch (Exception e) {
                    UIManager.showError(actionTarget, e.getMessage());
                }
            }
        });

        btnBack.setOnAction(actionEvent -> {
            stage.setScene(UIManager.getPreviousLayout());
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }
        stage.setTitle("CHANGE BOOK INFORMATION MENU");
        stage.setScene(scene);
        stage.show();
    }

    public void addMahasiswa(String name, String NIM, String faculy, String program) {
        Mahasiswa mahasiswa = new Mahasiswa(name, NIM, faculy, program);
        MAHASISWA_DATA.add(mahasiswa);
        mahasiswaList.add(NIM);
    }

    public boolean isAdmin(String username, String pass) throws illegalAdminAcces {
        if (username.equals(getAdminUserName()) && pass.equals(getAdminPassword()))
            return true;
        else
            throw new illegalAdminAcces("Invalid Credentials");
    }

    public String generateId() {
        Random random = new Random();

        StringBuilder idTengah = new StringBuilder();
        StringBuilder idAkhir = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idTengah.append(random.nextInt(10));
            idAkhir.append(random.nextInt(10));

        }
        return ("UMM-" + idTengah + "-" + idAkhir);

    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public static ArrayList<Mahasiswa> getMahasiswaData() {
        return MAHASISWA_DATA;
    }

    public static Book searchBookAll(String id) {
        for (Book book : Admin.getBookList())
            if (book.getBookId().equals(id))
                return book;
        return null;
    }

    public String getAdminPassword() {
        return adminPassword;
    }


    public static void sendMail(String message){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587"); // TLS Port
        props.put("mail.smtp.auth", "true"); // Enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        String mainEmail = "perpusahmadidka@gmail.com"; //EMAIL ADMIN
        String password = "ibyt sqjx ovmk vnwq"; //PASSWORDNYA ADMIN

        // Create a Session with the specified properties
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(mainEmail, password);
            }
        });
        // Email details
        String toEmail = "idikach30@gmail.com"; //pengguna
        String subject = "PERPUSTAKAAN"; 
        String body = "pesan dari perpus "; //message


         try {
            MimeMessage msg = new MimeMessage(session);
            // Set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(mainEmail, "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse(mainEmail, false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);
            System.out.println("Email Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    
}