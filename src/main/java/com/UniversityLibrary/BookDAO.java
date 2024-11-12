package com.UniversityLibrary;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final List<Book> books;

    public BookDAO(){
        this.books = new ArrayList<>();
        //Agregar algunos datos de prueba
        books.add(new Book("123", "El Quijote", "Miguel de Cervantes", 10, 5, "image.jpg"));
        books.add(new Book("0987654321", "Cien Años de Soledad", "Gabriel García Márquez", 8, 3, "imagen2.jpg"));
    }

    public Book getBookByIsbn(String isbn){
        for (Book book : books){
            if (book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void updateBook(Book book){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getIsbn().equals(book.getIsbn())){
                books.set(i, book);
                return;
            }
        }
    }
    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> getBooksByTitle(String searchTitle) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getBooksByAuthor(String searchAuthor) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(searchAuthor)) {
                result.add(book);
            }
        }
        return result;
    }
}
