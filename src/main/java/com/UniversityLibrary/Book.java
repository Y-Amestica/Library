package com.UniversityLibrary;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int amountInLibrary;
    private int amountAvailable;
    private String image;

    //Constructor
    public Book(String isbn, String title, String author, int amountInLibrary, int amountAvailable, String image){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.amountInLibrary = amountInLibrary;
        this.amountAvailable = amountAvailable;
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmountInLibrary() {
        return amountInLibrary;
    }

    public void setAmountInLibrary(int amountInLibrary) {
        this.amountInLibrary = amountInLibrary;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }
    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}