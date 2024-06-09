package com.main.user;

import com.main.Main;
import com.main.inter.MenuInterface;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin implements MenuInterface{
    @Override
    public void showMenu(Stage primaryStage) {
        primaryStage.setTitle("Admin Menu");

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

        Button checkBookButton = new Button("Cek Buku");
        grid.add(checkBookButton, 1, 2);

        Button logoutButton = new Button("Keluar");
        grid.add(logoutButton, 0, 3);

        addStudentButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Tambahkan Mahasiswa clicked");
        });

        addBookButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Tambahkan Buku clicked");
        });

        checkStudentButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Cek Mahasiswa clicked");
        });

        checkBookButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Cek Buku clicked");
        });

        logoutButton.setOnAction(e -> new Main().pilihanLogin(primaryStage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
