package com.Library;


public class Loan {
    private String loanId;
    private User user;
    private Book book;
    private boolean returnBook;

    public Loan(String loanId, User user, Book book) {
        this.loanId = loanId;
        this.user = user;
        this.book = book;
        this.returnBook = false;
    }

    public void markAsReturned(Book book, int quantity) {
        if (!returnBook) {
            returnBook = true;
            book.increaseCopies(quantity); // Usamos la cantidad que se pasa como argumento
            System.out.println("Book with isbn " + book.getIsbn() + " successfully returned.");
        } else {
            System.out.println("This book has already been returned.");
        }
    }


    public User getUser() {
        return user;
    }

    public Book getbook() {
        return book;
    }

    public void markAsReturned() {
    }

    public boolean isReturnBook() {
        return isReturnBook();}

    public Book getBook() {
        return null;
    }
}










