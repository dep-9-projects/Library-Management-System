package controller;

import db.Book;
import db.BooksDB;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Navigation;
import util.Routes;

import java.io.IOException;

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
        this.selectedBook = book;

        txtName.setText(selectedBook.getName());
        txtISBN.setText(selectedBook.getIsbnNumber());
        txtAuthor.setText(selectedBook.getAuthor());
        txtQty.setText(selectedBook.getQuantity()+"");


    }


    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        selectedBook.setName(txtName.getText());
        selectedBook.setIsbnNumber(txtISBN.getText());
        selectedBook.setAuthor(txtAuthor.getText());
        selectedBook.setQuantity(Integer.parseInt(txtQty.getText()));
        Navigation.navigate(Routes.BOOKS_MANAGEMENT);


    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }
}
