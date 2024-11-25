package com.Library;

public class Book {
    private String isbn;
    private String title;
    private int availableCopies;

    //Constructor
    public Book(String isbn, String title, int availableCopies){
        this.isbn = isbn;
        this.title = title;
        this.availableCopies = availableCopies;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void reduceCopies(){
        if (isAvailable()){
            availableCopies--;
        } else {
            System.out.println("There are no available copies.");
        }
    }
    public void increaseCopies(int quantity){
        if (isAvailable()){
            availableCopies++;
        }
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
    public int getAvailableCopies(){
        return availableCopies;
    }
    public int setAvailableCopies(int availableCopies){
        return availableCopies;
    }
}