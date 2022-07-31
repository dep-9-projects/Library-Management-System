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
        if (txtName.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Name Cannot be empty").show();
            txtName.requestFocus();
            return;
        }else if (txtISBN.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Enter valid ISBN !").show();
            txtISBN.requestFocus();
            return;
        } else if (BooksDB.findBook(txtISBN.getText())!=null) {
            new Alert(Alert.AlertType.ERROR,"Duplicate ISBN numbers are not allowed").show();
            txtISBN.requestFocus();
            return;
        } else if (!txtQty.getText().matches("\\d+")) {
            new Alert(Alert.AlertType.ERROR,"Invalid Quantity").show();
            txtQty.requestFocus();
            return;
        }

        BooksDB.addBook(new Book(txtISBN.getText(),txtName.getText(),txtAuthor.getText(),Integer.parseInt(txtQty.getText())));
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
