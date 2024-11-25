package com.Library;


public class Admin extends User {

    public Admin(String name, String id, char gender) {
        super(name, id, gender); // Llamamos al constructor de la clase base User
    }

    public void addBook(Book book, int quantity) {
        book.increaseCopies(quantity);
        System.out.println("Libro agregado: " + book.getTitle() + " con " + quantity + " copias.");
    }

    public void deleteBook(Book book) {
        System.out.println("Libro " + book.getTitle() + " ha sido eliminado.");
    }

    public void updateBook(Book book, int quantity) {
        book.increaseCopies(quantity);
        System.out.println("Cantidad de libros actualizada a " + book.getAvailableCopies() + " para " + book.getTitle());
    }

    @Override
    public void borrowBook(Book book) {
        System.out.println("El administrador no puede pedir libros prestados.");
    }

    @Override
    public void returnBook(Loan loan) {
        System.out.println("El administrador no puede devolver libros.");
    }
}


