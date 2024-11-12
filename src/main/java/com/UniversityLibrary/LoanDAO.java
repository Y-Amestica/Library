package com.UniversityLibrary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanDAO {
    private List<Loan> loans;

    public LoanDAO() {
        this.loans = new ArrayList<>();
        // Add some test data
        loans.add(new Loan("Yazmin", "12.458.358-1", new Date(), new Date(), null, 14));
    }

    // Obtiene un préstamo por ISBN y ID de usuario
    public Loan getLoanByIsbnAndId(String isbn, String id) {
        for (Loan loan : loans) {
            if (loan.getIsbn().equals(isbn) && loan.getId().equals(id)) {
                return loan;
            }
        }
        return null;
    }

    // Añade un nuevo préstamo a la lista
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    // Actualiza un préstamo existente
    public void updateLoan(Loan loan) {
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getIsbn().equals(loan.getIsbn()) && loans.get(i).getId().equals(loan.getId())) {
                loans.set(i, loan);
                return;
            }
        }
    }

    // Elimina un préstamo por ISBN y ID de usuario
    public void deleteLoan(String isbn, String id) {
        loans.removeIf(loan -> loan.getIsbn().equals(isbn) && loan.getId().equals(id));
    }

    // Obtiene todos los préstamos
    public List<Loan> getAllLoans() {
        return new ArrayList<>(loans);
    }
}
