package db;

import java.io.Serializable;

public class Book implements Serializable {
    String isbnNumber;
    String name;
    String author;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int quantity;

    public Book() {
    }

    public Book(String isbnNumber, String name, String author,int quantity) {
        this.isbnNumber = isbnNumber;
        this.name = name;
        this.author = author;
        this.quantity =quantity;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}
