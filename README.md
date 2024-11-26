# Simple Library Management System

## Overview

This is a simple Java-based library management system that allows users to manage books, users, and book loans. The system supports different user roles like **Admin**, **Student**, and **Teacher**, with different permissions for each. Users can borrow and return books, while administrators can manage the book collection.

This project is intended to demonstrate basic object-oriented programming principles in Java, including inheritance, polymorphism, and encapsulation.

## Features

- **Admin**: Can add, delete, and update books in the library.
- **Student**: Can borrow and return books.
- **Teacher**: Can borrow and return books (similar to students).
- **Books**: Users can borrow books if available, and return them when done. The book's availability is updated accordingly.
- **Loans**: Track the borrowing and returning of books with Loan records.

## Getting Started

To run this project, ensure you have **Java 8** or higher installed on your machine. Clone or download the repository and run the `App` class to start the application.

### Prerequisites

- Java 8 or higher
- IDE (Eclipse, IntelliJ, or any text editor)
- Command line (optional)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd library-management-system
   ```
3. Open the project in your preferred IDE.
4. Run the `App.java` class.

### Usage

Once the program is running, you will be presented with a menu with the following options:

1. **Show available books**: Displays all books in the library along with their ISBN and available copies.
2. **Add a book**: Allows you to add new books by specifying the ISBN, title, and number of copies.
3. **Borrow a book**: Allows a user to borrow a book by entering their user ID and the ISBN of the book.
4. **Return a book**: Allows a user to return a book by entering their user ID and the ISBN of the book.
5. **Show users**: Displays a list of registered users (students, teachers, and administrators).
6. **Exit**: Exits the application.

### Example Flow

1. **View available books**: Lists books with their available copies.
2. **Borrow a book**: Users can borrow a book if there are available copies.
3. **Return a book**: Once borrowed, users can return a book and increase the available copies.

### Example Output:

```bash
=== Library ===
1. Show available books
2. Add book
3. Borrow book
4. Return book
5. Show users
6. Exit
Select a choice: 1

=== Available books ===
Title: Java Programming, ISBN: 978-0135166307, Copies: 5
Title: Data Structures, ISBN: 978-0262033848, Copies: 3

Select a choice: 3
Enter user ID: S001
Enter ISBN: 978-0135166307
Java Programming borrowed successfully.

Select a choice: 4
Enter user ID: S001
Enter ISBN: 978-0135166307
Book with ISBN 978-0135166307 successfully returned.
```

## Project Structure

```
src/
 └── com/
      └── Library/
           ├── Admin.java
           ├── Book.java
           ├── Loan.java
           ├── Student.java
           ├── Teacher.java
           ├── User.java
           └── App.java
```

### Main Components:

- **User.java**: A base class for all users (Admin, Student, Teacher).
- **Book.java**: Represents a book in the library with attributes such as ISBN, title, and available copies.
- **Loan.java**: Keeps track of book loans, including whether a book has been returned.
- **Admin.java**: Represents administrators who can manage books.
- **Student.java**: Represents students who can borrow and return books.
- **Teacher.java**: Represents teachers who can borrow and return books.
- **App.java**: The entry point of the application that handles user interactions and the main menu.

## How It Works

1. **Initialization**: When the program starts, a set of sample users and books are created.
2. **Menu System**: A console menu allows the user to choose from various actions such as viewing books, borrowing books, returning books, and adding new books.
3. **Loan Management**: When a user borrows a book, the system checks availability and records the loan. When the book is returned, the system updates the available copies.
