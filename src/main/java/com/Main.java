import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Loan (Préstamo)
        Date inicio = new Date(2024, 10, 1); // 1 de noviembre de 2024
        Date fin = new Date(2024, 10, 10);   // 10 de noviembre de 2024
        Loan loan = new Loan("123456789", "12345678-9", inicio, fin, 10);

        // Establecer la fecha de devolución con retraso
        Date returnDate = new Date(2024, 10, 15); // 15 de noviembre de 2024
        loan.setReturnDate(returnDate);

        // Crear un objeto Return (Devolución)
        Return returnObj = new Return("123456789", "12345678-9", returnDate);

        // Calcular la multa
        double pricePerDay = 1000.0; // Tarifa diaria de 1000 CLP
        double fine = returnObj.calculateFine(loan, pricePerDay);

        // Mostrar la multa
        System.out.println("Multa por retraso: " + fine + " CLP");
    }
}
//public class Main {
//    public static void main(String[] args) {
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            PrestamoDAO prestamoDAO = new PrestamoDAO(connection);
//            DevolucionDAO devolucionDAO = new DevolucionDAO(connection);
//
//            // Registrar una devolución
//            Date fechaDevolucion = new Date(2024, 10, 15); // 15 de noviembre de 2024
//            Devolucion devolucion = new Devolucion("978-3-16-148410-0", "12345678-9", fechaDevolucion);
//            devolucionDAO.registrarDevolucion(devolucion);
//
//            // Calcular la multa
//            Prestamo prestamo = prestamoDAO.getAllPrestamos().get(0); // Obtener el primer préstamo como ejemplo
//            double tarifaPorDia = 1000.0; // Tarifa diaria de 1000 CLP
//            double multa = devolucionDAO.calcularMulta(prestamo, tarifaPorDia);
//
//            // Mostrar la multa
//            System.out.println("Multa por retraso: " + multa + " CLP");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
