package controller;

import db.Book;
import db.BooksDB;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.util.Optional;

public class AddBookModalFormController {
    public Button btnSave;
    public TextField txtName;
    public TextField txtISBN;
    public TextField txtAuthor;
    public TextField txtQty;

    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        //validate data

        BooksDB.addBook(new Book(txtISBN.getText(),txtName.getText(),txtAuthor.getText(),1));
        Navigation.navigate(Routes.BOOKS_MANAGEMENT);
        Optional<ButtonType> buttonType= new Alert(Alert.AlertType.CONFIRMATION,"Successfully added.Do you want to add Another book ?", ButtonType.YES,ButtonType.NO).showAndWait();

        if (buttonType.get()==ButtonType.YES){
            txtAuthor.clear();
            txtISBN.clear();
            txtName.clear();
            txtQty.clear();
            txtName.requestFocus();
        }else{
            txtAuthor.getScene().getWindow().hide();
        }

    }
}
