package db;

import java.util.ArrayList;

public class BooksDB {

    private static ArrayList<Book> booksDatabase = new ArrayList<Book>();

    static {
        booksDatabase.add(new Book(" 978-1118061145","Modern Physics 3rd Edition ","Modern Physics 3rd Edition ",1));
        booksDatabase.add(new Book(" 978-1118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 978-1118061145","The Science of Plants","DK ",1));
        booksDatabase.add(new Book(" 978-1118061145","Collective Illusions","Todd Rose ",1));
        booksDatabase.add(new Book(" 978-1118061145","DARK PSYCHOLOGY 6 BOOKS IN 1","BENEDICT GOLEMAN ",1));
        booksDatabase.add(new Book(" 978-1118061145","How to Analyze People with Dark Psychology","Joshua Johnson ",1));
        booksDatabase.add(new Book(" 978-1118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 978-1118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 978-1118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 978-1118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
        booksDatabase.add(new Book(" 978-1118061145","Mastering JavaScript Functional Programming","Federico Kereki ",1));
    }

    public static ArrayList<Book> getBooksDatabase() {
        return booksDatabase;
    }

    public static boolean addBook(Book book){
        booksDatabase.add(book);
        return true;
    }

    public static boolean removeBook(Book book){
        booksDatabase.add(book);
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
            if (book.isbnNumber.contains(text) || book.name.contains(text) || book.author.contains(text) ){
                searchResult.add(book);
            }
        }
        return searchResult;
    }




}
