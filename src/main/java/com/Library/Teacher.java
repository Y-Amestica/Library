package com.Library;

public class Teacher extends User {
    private String profession;

    public Teacher(String name, String id, char gender, String profession){
        super(name, id, gender);
        this.profession = profession;
    }
    @Override
    public void borrowBook (Book book){
        if (book.isAvailable()){
            Loan loan = new Loan("Loan" + book.getIsbn(), this, book);
            book.reduceCopies();
            System.out.println(book.getTitle() + "borrowed successfully");
        } else {
            System.out.println("Book not available");
        }
    }
    @Override
    public void returnBook (Loan loan){
        if (!loan.isReturnBook()){
            loan.markAsReturned();
            System.out.println(loan.getbook()+ "returned successfully");
        } else {
            System.out.println(("Book is already marked as returned"));
        }
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
}