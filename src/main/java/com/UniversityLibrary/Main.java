package com;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        LoanDAO loanDAO = new LoanDAO();
        ReturnDAO returnDAO = new ReturnDAO();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Biblioteca - Menú Principal");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Listar Usuarios");
            System.out.println("3. Agregar Libro");
            System.out.println("4. Listar Libros");
            System.out.println("5. Agregar Préstamo");
            System.out.println("6. Listar Préstamos");
            System.out.println("7. Agregar Devolución");
            System.out.println("8. Listar Devoluciones");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Género (M/F): ");
                    char gender = scanner.nextLine().charAt(0);
                    System.out.print("Carrera (para estudiantes) o Profesión (para profesores): ");
                    String extra = scanner.nextLine();
                    System.out.print("¿Es estudiante? (S/N): ");
                    char isStudent = scanner.nextLine().charAt(0);
                    if (isStudent == 'S' || isStudent == 's') {
                        userDAO.addUser(new Student(name, id, gender, extra));
                    } else {
                        userDAO.addUser(new Teacher(name, id, gender, extra));
                    }
                    break;
                case 2:
                    List<User> users = userDAO.getAllUsers();
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                case 3:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Autor: ");
                    String author = scanner.nextLine();
                    System.out.print("Cantidad en Biblioteca: ");
                    int amountInLibrary = scanner.nextInt();
                    System.out.print("Cantidad Disponible: ");
                    int amountAvailable = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Imagen: ");
                    String image = scanner.nextLine();
                    bookDAO.addBook(new Book(isbn, title, author, amountInLibrary, amountAvailable, image));
                    break;
                case 4:
                    List<Book> books = bookDAO.getAllBooks();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 5:
                    System.out.print("ISBN: ");
                    isbn = scanner.nextLine();
                    System.out.print("ID de Usuario: ");
                    id = scanner.nextLine();
                    Date start = new Date(); // Fecha actual
                    System.out.print("Fecha de Fin (yyyy-MM-dd): ");
                    String endDateStr = scanner.nextLine();
                    Date end = Date.valueOf(endDateStr); // Convertir a Date
                    loanDAO.addLoan(new Loan(isbn, id, start, end, null, 14));
                    break;
                case 6:
                    List<Loan> loans = loanDAO.getAllLoans();
                    for (Loan loan : loans) {
                        System.out.println(loan);
                    }
                    break;
                case 7:
                    System.out.print("ISBN: ");
                    isbn = scanner.nextLine();
                    System.out.print("ID de Usuario: ");
                    id = scanner.nextLine();
                    Date returnDate = new Date(); // Fecha actual
                    returnDAO.addReturn(new Return(isbn, id, returnDate));
                    break;
                case 8:
                    List<Return> returns = returnDAO.getAllReturns();
                    for (Return ret : returns) {
                        System.out.println(ret);
                    }
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}

