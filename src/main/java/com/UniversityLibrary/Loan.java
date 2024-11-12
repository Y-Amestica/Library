package com.UniversityLibrary;

import java.util.Date;

public class Loan {
    private String isbn;
    private String id;
    private Date start;
    private Date end;
    private Date returnDate;
    private int amountDays;

    //Constructor
    public Loan(String isbn, String id, Date start, Date end, Date returnDate, int amountDays){
        this.isbn = isbn;
        this.id = id;
        this.start = start;
        this.end = end;
        this.returnDate = returnDate;
        this.amountDays = amountDays;
    }
    //Metodos para calcular dias de retraso y actualizar fecha de devolucion

    public int calculateDelayDays() {

        if (returnDate != null && returnDate.after(end)) { //fechaDevolucion.getTime(): Obtiene el tiempo en milisegundos
            long diff = returnDate.getTime() - end.getTime(); //long: Se utiliza para almacenar números enteros grandes y diff:Calcula la diferencia en milisegundos entre la fecha de devolución y la fecha de vencimiento.
            return (int) (diff / (1000 * 60 * 60 * 24));
        }
        //diff / (1000 * 60 * 60 * 24): Convierte la diferencia de milisegundos a días.
        //1000: Milisegundos en un segundo.
        //60: Segundos en un minuto.
        //60: Minutos en una hora.
        //24: Horas en un día.
        //(int): Convierte el resultado a un entero, ya que el método devuelve un int.
        return 0;
        //Si la fecha de devolución es null o no es posterior a la fecha de vencimiento, el método devuelve 0, indicando que no hay días de retraso.
    }

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

    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getAmountDays() {
        return amountDays;
    }
    public void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
    }
}












