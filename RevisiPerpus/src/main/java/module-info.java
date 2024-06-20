module org.example.com.main.tugas6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.com.main.UI to javafx.base;
    opens org.example.com.main to javafx.fxml;

    exports org.example.com.main;
}