import com.Library.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Loan> loans = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear datos iniciales
        initializeData();

        // Mostrar el menú
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Biblioteca ===");
            System.out.println("1. Mostrar libros disponibles");
            System.out.println("2. Agregar un libro");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Mostrar usuarios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    showUsers();
                    break;
                case 6:
                    exit = true;
                    System.out.println("¡Gracias por usar la biblioteca!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void initializeData() {
        books.add(new Book("978-0135166307", "Java Programming", 5));
        books.add(new Book("978-0262033848", "Data Structures", 3));

        users.add(new Student("Laura", "S001", 'F', "Computer Science"));
        users.add(new Teacher("John", "T001", 'M', "Mathematics"));

        System.out.println("Datos iniciales cargados.");
    }

    private static void showAvailableBooks() {
        System.out.println("\n=== Libros Disponibles ===");
        for (Book book : books) {
            System.out.println("Título: " + book.getTitle() + ", ISBN: " + book.getIsbn() + ", Copias: " + book.getAvailableCopies());
        }
    }

    private static void addBook() {
        System.out.println("\n=== Agregar Libro ===");
        System.out.print("Ingrese el ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Ingrese el título: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la cantidad de copias: ");
        int copies = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        books.add(new Book(isbn, title, copies));
        System.out.println("Libro agregado exitosamente.");
    }

    private static void borrowBook() {
        System.out.println("\n=== Prestar Libro ===");
        System.out.print("Ingrese el ID del usuario: ");
        String userId = scanner.nextLine();
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (book.isAvailable()) {
            user.borrowBook(book);
            Loan loan = new Loan("Loan-" + isbn, user, book);
            loans.add(loan);
        } else {
            System.out.println("No hay copias disponibles para este libro.");
        }
    }

    private static void returnBook() {
        System.out.println("\n=== Devolver Libro ===");
        System.out.print("Ingrese el ID del usuario: ");
        String userId = scanner.nextLine();
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();
        Loan loan = findLoan(user, isbn);
        if (loan == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        if (!loan.isReturnBook()) {
            loan.markAsReturned();
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("Este libro ya fue devuelto.");
        }
    }

    private static void showUsers() {
        System.out.println("\n=== Usuarios Registrados ===");
        for (User user : users) {
            System.out.println("Nombre: " + user.getName() + ", ID: " + user.getId());
        }
    }

    private static User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(id)) {
                return user;
            }
        }
        return null;
    }

    private static Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    private static Loan findLoan(User user, String isbn) {
        for (Loan loan : loans) {
            if (loan.getUser().equals(user) && loan.getbook().getIsbn().equalsIgnoreCase(isbn)) {
                return loan;
            }
        }
        return null;
    }
}
