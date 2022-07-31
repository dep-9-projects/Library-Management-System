package controller;

import db.Book;
import db.BooksDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class BooksManagementFormController {

    public TableView<Book> tblBooks;
    public Button btnAddBook;
    public TextField txtSearch;

    public void initialize(){

        tblBooks.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("isbnNumber"));
        tblBooks.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBooks.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBooks.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tblBooks.getSelectionModel().clearSelection();

        tblBooks.setItems(FXCollections.observableArrayList(BooksDB.getBooksDatabase()));

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String pre, String current) {
                if (pre.equals(current)) return;

                tblBooks.setItems(FXCollections.observableArrayList(BooksDB.searchBooks(current)));
                tblBooks.refresh();
            }
        });

        tblBooks.setRowFactory(tv -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Book selBook = row.getItem();

                    try {
                        URL resource = this.getClass().getResource("/view/UpdateBookModalForm.fxml");
                        FXMLLoader fxmlLoader = new FXMLLoader(resource);
                        Parent updateFormContainer = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(updateFormContainer));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        UpdateBookModalFormController updateFormController = fxmlLoader.getController();
                        updateFormController.init(selBook.getIsbnNumber());


                        stage.show();
                        stage.centerOnScreen();
                        stage.setTitle("Update Selected Book");


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            return row ;
        });


    }

    public void btnAddBookOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/AddBookModalForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent container = fxmlLoader.load();
        Scene addBookScene = new Scene(container);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(addBookScene);
        stage.setTitle("Add Book");
        stage.centerOnScreen();
        stage.show();



    }

}
