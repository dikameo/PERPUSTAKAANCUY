package com.main;

import com.main.user.Admin;
import com.main.user.Mahasiswa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        pilihanLogin(primaryStage);
    }


    private void loginAdmin(Stage primaryStage) {
        primaryStage.setTitle("Admin Login Form");

        // Membuat GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        // Menambahkan komponen ke GridPane
        Text sceneTitle = new Text("Welcome Admin");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        grid.add(btn, 1, 4);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        btn.setOnAction(e -> {
            if (userTextField.getText().equals("admin") && pwBox.getText().equals("password")) {
                new Admin().showMenu(primaryStage);
            } else {
                actionTarget.setId("action-target");
                actionTarget.setText("Invalid credentials");
            }
        });

        Button backButton = new Button("Kembali");
        grid.add(backButton, 1, 7);
        backButton.setOnAction(e -> pilihanLogin(primaryStage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    
    private void loginMahasiswa(Stage primaryStage) {
        primaryStage.setTitle("User Login Form");

        // Membuat GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        // Menambahkan komponen ke GridPane
        Text sceneTitle = new Text("Welcome User");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label nimLabel = new Label("NIM:");
        grid.add(nimLabel, 0, 1);

        TextField nimTextField = new TextField();
        grid.add(nimTextField, 1, 1);

        Button btn = new Button("Login");
        grid.add(btn, 1, 2);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 4);

        btn.setOnAction(e -> {
            // Assume successful login for demo purposes
            new Mahasiswa(nimTextField.getText()).showMenu(primaryStage);
        });

        Button backButton = new Button("Kembali");
        grid.add(backButton, 1, 5);
        backButton.setOnAction(e -> pilihanLogin(primaryStage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }



    public void pilihanLogin(Stage primaryStage) {
        primaryStage.setTitle("Pilih Login");

        // Membuat GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(25, 25, 25, 25));

        // Menambahkan komponen ke GridPane
        Text sceneTitle = new Text("Pilih Login");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Button adminLoginButton = new Button("Admin Login");
        grid.add(adminLoginButton, 0, 1);

        Button userLoginButton = new Button("User Login");
        grid.add(userLoginButton, 1, 1);

        adminLoginButton.setOnAction(e -> loginAdmin(primaryStage));
        userLoginButton.setOnAction(e -> loginMahasiswa(primaryStage));

        // Mengatur scene dengan grid dan CSS
        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
