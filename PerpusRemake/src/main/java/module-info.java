module com.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.main to javafx.graphics;
    exports com.main;

    opens com.main.user to javafx.graphics;
    exports com.main.user;
}
