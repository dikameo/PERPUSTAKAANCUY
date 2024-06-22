module org.example.com.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.mail;

    opens org.example.com.main.UI to javafx.base;
    // opens org.example.com.main to javafx.fxml;
    opens org.example.com.main to javafx.graphics;

    exports org.example.com.main;
    


}