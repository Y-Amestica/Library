package com;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final List<Book> books;

    public BookDAO(){
        this.books = new ArrayList<>();
        //Agregar algunos datos de prueba
        books.add(new Book("123", "El Quijote", "Miguel de Cervantes", 10, 5, "image.jpg"));
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
}