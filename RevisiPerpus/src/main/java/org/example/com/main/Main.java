package org.example.com.main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.com.main.UI.UIManager;
import org.example.com.main.books.Book;
import org.example.com.main.data.Admin;
import org.example.com.main.data.Mahasiswa;
import org.example.com.main.data.User;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application{
    public static void main(String[] args) {
        addUser();
        // Admin.sendMail(STYLESHEET_CASPIAN);
        launch(args);
    }
    public static void addUser(){
        Mahasiswa mahasiswa1 = new Mahasiswa("AGUS","202310370311080","FT","INFORMATIKA","idikach30@gmail.com");
        Mahasiswa mahasiswa2 = new Mahasiswa("AHMAD","202310370311091","FT","INFORMATIKA","bijuudama30@gmail.com");
        Mahasiswa mahasiswa3 = new Mahasiswa("Jukii","202310370311071","FT","INFORMATIKA","bijuudama45@gmail.com");
        Mahasiswa mahasiswa4 = new Mahasiswa("Natsha","202310370311072","FT","INFORMATIKA","bijuudama53@gmail.com");
        Admin.getMahasiswaData().add(mahasiswa1);
        Admin.getMahasiswaData().add(mahasiswa2);
        Admin.getMahasiswaData().add(mahasiswa3);
        Admin.getMahasiswaData().add(mahasiswa4);
        Book book1 = new Book("UMM-202-301","Ilmu Hitam", "Nyi Towok",100);
        Book book2 = new Book("UMM-512-131","Ilmu alam", "Naga Sakti",100);
        book1.setCategory("Sejarah");
        User.getBookList().add(book1);
        book1.setDuration(9);
        mahasiswa1.getBorrowedBooks().add(book1);
    }

        @Override
    public void start(Stage stage) throws Exception {
        menu(stage);
    }
    public static void menu(Stage stage)throws IOException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        double width = 462; 
        double height = 100;
        ImageView imageViewLogo = new ImageView(new Image(Main.class.getResourceAsStream("img/LOGO.png")));
        imageViewLogo.setFitWidth(width);
        imageViewLogo.setFitHeight(height);
        VBox hboxBtn = new VBox(10);
        Button btnLogAdmin = new Button("Login As Admin");
        Button btnLogStudent = new Button("Login As Mahasiswa");
        Button btnExit = new Button("EXIT");

        double buttonWidth = 150; // Tentukan lebar tombol
        double buttonHeight = 30; // Tentukan tinggi tombol
        btnLogAdmin.setPrefSize(buttonWidth, buttonHeight);
        btnLogStudent.setPrefSize(buttonWidth, buttonHeight);
        btnExit.setPrefSize(buttonWidth, buttonHeight);

        hboxBtn.setAlignment(Pos.CENTER);
        hboxBtn.getChildren().addAll(imageViewLogo,btnLogAdmin, btnLogStudent, btnExit);
        grid.add(hboxBtn, 1, 3);

        final Text actionTarget = new Text();
        actionTarget.setWrappingWidth(200); // Set a fixed width to prevent layout changes
        grid.add(actionTarget, 1, 6);

        btnLogAdmin.setOnAction(actionEvent -> {
            try {
                Admin.logIn(stage);
            } catch (Exception e) {
                actionTarget.setText("An error occurred: " + e.getMessage());
            }
        });

        btnLogStudent.setOnAction(actionEvent -> {
            try {
                Mahasiswa.logIn(stage);
            } catch (Exception e) {
                actionTarget.setText("An error occurred: " + e.getMessage());
            }
        });

        btnExit.setOnAction(actionEvent -> {
            try {
                stage.close();
            } catch (Exception e) {
                actionTarget.setText("An error occurred: " + e.getMessage());
            }
        });

        Scene scene = new Scene(grid, UIManager.getWidth(), UIManager.getHeight());

        // Apply the CSS file with error handling
        try {
            scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        } catch (NullPointerException e) {
            System.err.println("Error: CSS file not found. Please ensure style.css is in the correct directory.");
            e.printStackTrace();
        }

        stage.setTitle("PERPUSTAKAAN CUY");
        stage.setScene(scene);
        stage.show();
    }
    public static String inputNIM(){
        Scanner inputObj = new Scanner(System.in);
        return inputObj.nextLine();
    }
    public static void addTempMahasiswa(Admin admin,String name,String NIM, String faculty, String program, String email) {
        admin.addMahasiswa(name,NIM,faculty,program, email);
    }

    public static Mahasiswa checkNIM(String name, String NIM, String faculty, String program, String email) {
        for (Mahasiswa x : Admin.getMahasiswaData()) {
            if (x.getNIM().equals(NIM)) {
                return null;
            }
        }
        return new Mahasiswa(name, NIM, faculty, program, email);
    }
    public static void addTempBook(Mahasiswa mahasiswa, int numberBorrowed, String[][] arr) {
        for (int i = 0; i < numberBorrowed; i++)
            mahasiswa.choiceBook(arr[i][0],Integer.parseInt(arr[i][1]));
    }

    public static void addTempBookAdmin(Admin admin, int numberBorrowed, String[][] arr) {
        for (int i = 0; i < numberBorrowed; i++)
            admin.choiceBook(arr[i][0],Integer.parseInt(arr[i][1]));
    }

}