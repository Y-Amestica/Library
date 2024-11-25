package com.Library;

public abstract class User {
    private String name;
    private String id;
    private char gender;

    public abstract void borrowBook (Book book);
    public abstract void returnBook (Loan loan);


    //Constructor
    public User(String name, String id, char gender){
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public User(String id) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
