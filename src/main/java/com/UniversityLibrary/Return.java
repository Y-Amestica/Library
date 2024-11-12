package com.UniversityLibrary;

import java.util.Date;

public class Return {
    private String isbn;
    private String id;
    private Date returnDate;

    //Constructor
    public Return(String isbn, String id, Date returnDate){
        this.isbn = isbn;
        this.id = id;
        this.returnDate = returnDate;
    }

    //Metodos para Calcular Multa
    //public double calculateFine(Loan loan, double pricePerDay){
      //  int delayDays = loan.calculateDelayDays();
     //   return delayDays * pricePerDay;
    //}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
