package com.main.user;

import com.main.Main;
import com.main.inter.MenuInterface;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Mahasiswa implements MenuInterface{
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

        Button borrowedBooksButton = new Button("Buku yang Terpinjam");
        grid.add(borrowedBooksButton, 1, 1);

        Button availableBooksButton = new Button("Buku yang Tersedia");
        grid.add(availableBooksButton, 0, 2);

        Button userDataButton = new Button("Data User");
        grid.add(userDataButton, 1, 2);

        Button fineNotificationButton = new Button("Notifikasi Denda");
        grid.add(fineNotificationButton, 0, 3);

        Button logoutButton = new Button("Keluar");
        grid.add(logoutButton, 1, 3);

        borrowBookButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Pinjam Buku clicked");
        });

        borrowedBooksButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Buku yang Terpinjam clicked");
        });

        availableBooksButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Buku yang Tersedia clicked");
        });

        userDataButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Data User clicked");
        });

        fineNotificationButton.setOnAction(e -> {
            // Placeholder: Ganti dengan fungsi atau tampilan yang sesuai
            System.out.println("Notifikasi Denda clicked");
        });

        logoutButton.setOnAction(e -> new Main().pilihanLogin(primaryStage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
