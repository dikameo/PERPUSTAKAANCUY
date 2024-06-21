package com.main.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.main.UI.PropertyBook;
import com.main.database.Book*;
import java.util.ArrayList;

public abstract class User {
    private static ArrayList<Book> bookList =new ArrayList<>();
    public abstract void updateBooks(Stage primaryStage);
    public void addBook (Book book){
        bookList.add(book);
    }

    public void showAvailableBook(Stage primaryStage){}
    public abstract void logOut(Stage primaryStage);

    public TableView<PropertyBook> createTableView(ArrayList<Book> arr){
        TableView<PropertyBook> table = new TableView<>();
        table.setEditable(false);
        table.getColumns().clear();

        TableColumn<PropertyBook,String> kodebukuCol = new TableColumn<>("Id");
        TableColumn<PropertyBook,String> judulCol = new TableColumn<>("Title");
        TableColumn<PropertyBook,String> penulisCol = new TableColumn<>("Author");
        TableColumn<PropertyBook,Integer> stockCol = new TableColumn<>("Stock");
        TableColumn<PropertyBook, String> categoryCol = new TableColumn<>("Category");

        kodebukuCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        judulCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        penulisCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        table.getColumns().addAll(kodebukuCol,judulCol,penulisCol,stockCol,categoryCol);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(table);
        gridPane.add(vbox, 0, 0);

        ArrayList<PropertyBook> convertBook = PropertyBook.bookToProperty(arr);
        final ObservableList<PropertyBook> data = FXCollections.observableArrayList(convertBook);
        table.setItems(data);
        return table;
    }
    public static ArrayList<Book> getBookList(){
        return bookList;
    }



}
