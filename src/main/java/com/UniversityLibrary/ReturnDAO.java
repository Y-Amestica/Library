package com.UniversityLibrary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnDAO {
    private List<Return> returns;

    public ReturnDAO() {
        this.returns = new ArrayList<>();
        // Add some test data
        returns.add(new Return("Yazmin", "12.458.358-1", new Date()));
    }

    public double calculateFine(Loan loan, double pricePerDay){
        int delayDays = loan.calculateDelayDays();
        return delayDays * pricePerDay;
    }

    // Obtiene una devolución por ISBN y ID de usuario
    public Return getReturnByIsbnAndId(String isbn, String id) {
        for (Return ret : returns) {
            if (ret.getIsbn().equals(isbn) && ret.getId().equals(id)) {
                return ret;
            }
        }
        return null;
    }

    // Añade una nueva devolución a la lista
    public void addReturn(Return ret) {
        returns.add(ret);
    }

    // Actualiza una devolución existente
    public void updateReturn(Return ret) {
        for (int i = 0; i < returns.size(); i++) {
            if (returns.get(i).getIsbn().equals(ret.getIsbn()) && returns.get(i).getId().equals(ret.getId())) {
                returns.set(i, ret);
                return;
            }
        }
    }

    // Elimina una devolución por ISBN y ID de usuario
    public void deleteReturn(String isbn, String id) {
        returns.removeIf(ret -> ret.getIsbn().equals(isbn) && ret.getId().equals(id));
    }

    // Obtiene todas las devoluciones
    public List<Return> getAllReturns() {
        return new ArrayList<>(returns);
    }
}
