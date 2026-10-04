import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You borrowed: " + title);
        } 
        else {
            System.out.println("Sorry, " + title + " is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You returned: " + title);
        } 
        else {
            System.out.println("This book was not borrowed.");
        }
    }

    public void displayInfo() {
        String status = isBorrowed ? "Borrowed" : "Available";
        System.out.println("Title: " + title + " | Author: " + author + " | Status: " + status);
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Clean Code", "Robert Martin"));

        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                library.displayBooks();
            } 
            else if (choice == 2) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(title, author));
            } 
            else if (choice == 3) {
                System.out.print("Enter title of book to borrow: ");
                String title = scanner.nextLine();
                Book book = library.findBook(title);
                if (book != null) {
                    book.borrowBook();
                } 
                else {
                    System.out.println("Book not found!");
                }
            } 
            else if (choice == 4) {
                System.out.print("Enter title of book to return: ");
                String title = scanner.nextLine();
                Book book = library.findBook(title);
                if (book != null) {
                    book.returnBook();
                } 
                else {
                    System.out.println("Book not found!");
                }
            } 
            else if (choice == 5) {
                System.out.println("Exiting Library Management System. Goodbye!");
            } 
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}