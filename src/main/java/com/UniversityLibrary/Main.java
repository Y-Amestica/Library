package com.UniversityLibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicialización de los DAOs
        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        LoanDAO loanDAO = new LoanDAO();
        ReturnDAO returnDAO = new ReturnDAO();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Simulación de inicio de sesión
        System.out.print("Ingrese su ID de usuario: ");
        String currentUserId = scanner.nextLine();
        User currentUser = userDAO.getUserById(currentUserId);

        if (currentUser == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        while (running) {
            // Menú principal
            System.out.println("Biblioteca - Menú Principal");
            if (currentUser instanceof Admin) {
                // Opciones exclusivas para administradores
                System.out.println("1. Agregar Usuario (Solo Administrador)");
                System.out.println("2. Listar Usuarios");
                System.out.println("3. Agregar Libro (Solo Administrador)");
                System.out.println("4. Modificar Libro (Solo Administrador)");
                System.out.println("5. Eliminar Libro (Solo Administrador)");
            }
            // Opciones disponibles para todos los usuarios
            System.out.println("6. Listar Libros");
            System.out.println("7. Agregar Préstamo");
            System.out.println("8. Listar Préstamos");
            System.out.println("9. Agregar Devolución");
            System.out.println("10. Listar Devoluciones");
            System.out.println("11. Ver Multas");
            System.out.println("12. Buscar Libro");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Agregar usuario (solo para administradores)
                    if (currentUser instanceof Admin) {
                        System.out.print("Nombre: ");
                        String name = scanner.nextLine();
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Género (M/F): ");
                        char gender = scanner.nextLine().charAt(0);
                        System.out.print("Carrera (para estudiantes), Profesión (para profesores) o Rol (para administradores): ");
                        String extra = scanner.nextLine();
                        System.out.print("Tipo de usuario (Estudiante/Profesor/Administrador): ");
                        String userType = scanner.nextLine();
                        if (userType.equalsIgnoreCase("Estudiante")) {
                            userDAO.addUser(new Student(name, id, gender, extra));
                        } else if (userType.equalsIgnoreCase("Profesor")) {
                            userDAO.addUser(new Teacher(name, id, gender, extra));
                        } else if (userType.equalsIgnoreCase("Administrador")) {
                            userDAO.addUser(new Admin(name, id, gender, extra));
                        } else {
                            System.out.println("Tipo de usuario no válido.");
                        }
                    } else {
                        System.out.println("Permiso denegado. Solo los administradores pueden agregar usuarios.");
                    }
                    break;
                case 2:
                    // Listar usuarios (solo para administradores)
                    if (currentUser instanceof Admin) {
                        List<User> users = userDAO.getAllUsers();
                        for (User user : users) {
                            System.out.println(user);
                        }
                    } else {
                        System.out.println("Permiso denegado. Solo los administradores pueden listar usuarios.");
                    }
                    break;
                case 3:
                    // Agregar libro (solo para administradores)
                    if (currentUser instanceof Admin) {
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
                    } else {
                        System.out.println("Permiso denegado. Solo los administradores pueden agregar libros.");
                    }
                    break;
                case 4:
                    // Modificar libro (solo para administradores)
                    if (currentUser instanceof Admin) {
                        System.out.print("ISBN del libro a modificar: ");
                        String isbnToModify = scanner.nextLine();
                        Book book = bookDAO.getBookByIsbn(isbnToModify);
                        if (book != null) {
                            System.out.print("Nuevo Título: ");
                            String title = scanner.nextLine();
                            System.out.print("Nuevo Autor: ");
                            String author = scanner.nextLine();
                            System.out.print("Nueva Cantidad en Biblioteca: ");
                            int amountInLibrary = scanner.nextInt();
                            System.out.print("Nueva Cantidad Disponible: ");
                            int amountAvailable = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Nueva Imagen: ");
                            String image = scanner.nextLine();
                            book.setTitle(title);
                            book.setAuthor(author);
                            book.setAmountInLibrary(amountInLibrary);
                            book.setAmountAvailable(amountAvailable);
                            book.setImage(image);
                            bookDAO.updateBook(book);
                            System.out.println("Libro actualizado exitosamente.");
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Permiso denegado. Solo los administradores pueden modificar libros.");
                    }
                    break;
                case 5:
                    // Eliminar libro (solo para administradores)
                    if (currentUser instanceof Admin) {
                        System.out.print("ISBN del libro a eliminar: ");
                        String isbnToDelete = scanner.nextLine();
                        bookDAO.deleteBook(isbnToDelete);
                        System.out.println("Libro eliminado exitosamente.");
                    } else {
                        System.out.println("Permiso denegado. Solo los administradores pueden eliminar libros.");
                    }
                    break;
                case 6:
                    // Listar libros (disponible para todos los usuarios)
                    List<Book> books = bookDAO.getAllBooks();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 7:
                    // Agregar préstamo (disponible para todos los usuarios)
                    System.out.print("ISBN: ");
                    String isbnForLoan = scanner.nextLine();
                    System.out.print("ID de Usuario: ");
                    String idForLoan = scanner.nextLine();
                    Date start = new Date(); // Fecha actual
                    System.out.print("Fecha de Fin (yyyy-MM-dd): ");
                    String endDateStr = scanner.nextLine();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date end = dateFormat.parse(endDateStr); // Convertir a Date
                        loanDAO.addLoan(new Loan(isbnForLoan, idForLoan, start, end, null, 14));
                        System.out.println("Préstamo agregado exitosamente.");
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha incorrecto. Por favor, use yyyy-MM-dd.");
                    }
                    break;
                case 8:
                    // Listar préstamos (disponible para todos los usuarios)
                    List<Loan> loans = loanDAO.getAllLoans();
                    for (Loan loan : loans) {
                        System.out.println(loan);
                    }
                    break;
                case 9:
                    // Agregar devolución (disponible para todos los usuarios)
                    System.out.print("ISBN: ");
                    String isbnForReturn = scanner.nextLine();
                    System.out.print("ID de Usuario: ");
                    String idForReturn = scanner.nextLine();
                    Date returnDate = new Date(); // Fecha actual
                    Loan loanToReturn = loanDAO.getLoanByIsbnAndId(isbnForReturn, idForReturn);
                    if (loanToReturn != null) {
                        loanToReturn.setReturnDate(returnDate);
                        returnDAO.addReturn(new Return(isbnForReturn, idForReturn, returnDate));
                        double fine = returnDAO.calculateFine(loanToReturn, 100); // Suponiendo que el precio por día de retraso es 100 unidades monetarias
                        if (fine > 0) {
                            System.out.println("Multa por retraso: " + fine + " unidades monetarias.");
                        } else {
                            System.out.println("No hay multas.");
                        }
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                    break;
                case 10:
                    // Listar devoluciones (disponible para todos los usuarios)
                    List<Return> returns = returnDAO.getAllReturns();
                    for (Return ret : returns) {
                        System.out.println(ret);
                    }
                    break;
                case 11:
                    // Ver multas (disponible para todos los usuarios)
                    System.out.print("ID de Usuario: ");
                    String idForFine = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbnForFine = scanner.nextLine();
                    Loan loanForFine = loanDAO.getLoanByIsbnAndId(isbnForFine, idForFine);
                    if (loanForFine != null) {
                        int delayDays = loanForFine.calculateDelayDays();
                        if (delayDays > 0) {
                            System.out.println("Multa por retraso: " + delayDays * 100 + " unidades monetarias.");
                        } else {
                            System.out.println("No hay multas.");
                        }
                    } else {
                        System.out.println("Préstamo no encontrado.");
                    }
                    break;
                case 12:
                    // Buscar libro (disponible para todos los usuarios)
                    System.out.print("Buscar por (1) Título o (2) Autor: ");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (searchOption == 1) {
                        System.out.print("Ingrese el título: ");
                        String searchTitle = scanner.nextLine();
                        books = bookDAO.getBooksByTitle(searchTitle);
                    } else if (searchOption == 2) {
                        System.out.print("Ingrese el autor: ");
                        String searchAuthor = scanner.nextLine();
                        books = bookDAO.getBooksByAuthor(searchAuthor);
                    } else {
                        System.out.println("Opción no válida.");
                        break;
                    }
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 13:
                    // Salir
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
