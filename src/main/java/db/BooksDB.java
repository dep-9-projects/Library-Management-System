package db;

import java.util.ArrayList;

public class BooksDB {

    private static ArrayList<Book> booksDatabase = new ArrayList<Book>();

    static {
        booksDatabase.add(new Book(" 9758-11180611454","Modern Physics 3rd Edition ","Modern Physics 3rd Edition ",1));
        booksDatabase.add(new Book(" 9728-11180611453","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 9738-11180611454","The Science of Plants","DK ",1));
        booksDatabase.add(new Book(" 9748-11180561145","Collective Illusions","Todd Rose ",1));
        booksDatabase.add(new Book(" 9758-11180761145","DARK PSYCHOLOGY 6 BOOKS IN 1","BENEDICT GOLEMAN ",1));
        booksDatabase.add(new Book(" 9768-11180861145","How to Analyze People with Dark Psychology","Joshua Johnson ",1));
        booksDatabase.add(new Book(" 9778-11180641145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 9788-11180361145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 9798-11180261145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 97108-51118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 97118-11518061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
    }

    public static ArrayList<Book> getBooksDatabase() {
        return booksDatabase;
    }

    public static boolean addBook(Book book){
        booksDatabase.add(book);
        return true;
    }

    public static boolean removeBook(Book book){
        booksDatabase.remove(book);
        return true;
    }

    public static Book findBook(String isbn){
        for (Book book : booksDatabase) {
            if (book.isbnNumber.equals(isbn)){
                return book;
            }
        }
        return null;
    }
    public static ArrayList<Book> searchBooks(String text){
        ArrayList<Book> searchResult =new ArrayList<>();
        for (Book book : booksDatabase) {
            if (book.isbnNumber.toUpperCase().contains(text.toUpperCase())|| book.name.toUpperCase()
                    .contains(text.toUpperCase()) || book.author.toUpperCase().contains(text.toUpperCase()) ){
                searchResult.add(book);
            }
        }
        return searchResult;
    }




}
