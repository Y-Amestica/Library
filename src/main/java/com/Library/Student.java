package com.Library;

public class Student extends User {
    private String career;

    public Student(String name, String id, char gender, String career) {
        super(name, id, gender);
        this.career = career;
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            Loan loan = new Loan("Loan-" + book.getIsbn(), this, book);
            book.reduceCopies();
            System.out.println(book.getTitle() + " prestado exitosamente.");
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    @Override
    public void returnBook(Loan loan) {
        if (!loan.isReturnBook()) {
            loan.markAsReturned();
            System.out.println("Libro " + loan.getBook().getTitle() + " devuelto exitosamente.");
        } else {
            System.out.println("Este libro ya fue devuelto.");
        }
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}

