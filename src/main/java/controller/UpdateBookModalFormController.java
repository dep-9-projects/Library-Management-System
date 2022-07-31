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

public class UpdateBookModalFormController {
    public TextField txtName;
    public TextField txtISBN;
    public TextField txtAuthor;
    public TextField txtQty;
    public Button btnUpdate;
    public Button btnRemove;

    private Book selectedBook;



    public void init(String isbn) {
        Book book =BooksDB.findBook(isbn);
        System.out.println(book.getName());
        this.selectedBook = book;

        txtName.setText(selectedBook.getName());
        txtISBN.setText(selectedBook.getIsbnNumber());
        txtAuthor.setText(selectedBook.getAuthor());
        txtQty.setText(selectedBook.getQuantity()+"");
        txtISBN.setEditable(false);

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        selectedBook.setName(txtName.getText());
        selectedBook.setIsbnNumber(txtISBN.getText());
        selectedBook.setAuthor(txtAuthor.getText());

        if(txtName.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Name Cannot be empty").show();
            txtName.requestFocus();
            return;
        }else if (txtISBN.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Enter valid ISBN !").show();
            txtISBN.requestFocus();
            return;
        }else if (!txtQty.getText().matches("\\d+")) {
            new Alert(Alert.AlertType.ERROR,"Invalid Quantity").show();
            txtQty.requestFocus();
            return;
        }
        selectedBook.setQuantity(Integer.parseInt(txtQty.getText()));
        btnRemove.getScene().getWindow().hide();
        Navigation.navigate(Routes.BOOKS_MANAGEMENT);

    }

    public void btnRemoveOnAction(ActionEvent actionEvent) throws IOException {
        Optional<ButtonType> buttonType =new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete the book from system ?",
                ButtonType.YES,ButtonType.NO).showAndWait();

        if (buttonType.get()==ButtonType.YES){
            BooksDB.removeBook(selectedBook);
            new Alert(Alert.AlertType.INFORMATION,"Successfully deleted book!").show();
            btnRemove.getScene().getWindow().hide();
            Navigation.navigate(Routes.BOOKS_MANAGEMENT);
        } else if (buttonType.get() ==ButtonType.NO) {
            btnRemove.getScene().getWindow().hide();
        }

    }
}
