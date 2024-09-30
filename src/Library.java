/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and its processing
 * Student Name: Atharv Bhuskat
 * Student Number: 41128374       
 * Section #:  311 
 * Course: CST8130 - Data Structures
 * Professor: Narges Tabar 
 */

/**
 * The Library class represents a collection of books in a library.
 * It allows for adding books, finding books, borrowing, and returning books.
 */
public class Library {
    private Book[] catalog;  // Array to hold the collection of books
    private int numBooks;    // Counter for the number of books in the catalog

    /**
     * Default constructor for the Library class.
     * It initializes the catalog with a fixed size of 20 books.
     */
    public Library() {
        catalog = new Book[20]; // Initialize catalog with a capacity of 20 books
        numBooks = 0;           // Initialize the number of books to zero
    }

    /**
     * Returns a string representation of the library catalog.
     * It includes a list of all books in the library or a message if the catalog is empty.
     *
     * @return A string representing the library catalog.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Library Catalog:\n");
        if (numBooks == 0) {
            return "Library is empty."; // Message if there are no books in the catalog
        }
        for (int i = 0; i < numBooks; i++) {
            sb.append(catalog[i].toString()).append("\n"); // Append each book's details
        }
        return sb.toString(); // Return the complete catalog as a string
    }

    /**
     * Checks if a given book already exists in the catalog.
     *
     * @param book The Book object to check for existence.
     * @return true if the book exists, false otherwise.
     */
    public boolean alreadyExists(Book book) {
        for (int i = 0; i < numBooks; i++) {
            if (catalog[i].isEqual(book)) {
                return true; // Book exists if titles and authors match
            }
        }
        return false; // Book does not exist in the catalog
    }

    /**
     * Adds a book to the catalog if it doesn't already exist.
     *
     * @param book The Book object to be added to the catalog.
     * @return true if the book was added successfully, false otherwise.
     */
    public boolean addBook(Book book) {
        if (alreadyExists(book)) {
            System.out.println("Book code already exists."); // Inform if the book already exists
            return false; // Cannot add the book
        }
        if (numBooks < catalog.length) {
            catalog[numBooks] = book; // Add the book to the catalog
            numBooks++; // Increment the number of books
            return true; // Successfully added the book
        } else {
            System.out.println("Library is full."); // Inform if the catalog is full
            return false; // Cannot add the book
        }
    }

    /**
     * Finds a book in the catalog by its book code.
     *
     * @param bookCode The code of the book to find.
     * @return The Book object if found, null otherwise.
     */
    public Book findBook(int bookCode) {
        for (int i = 0; i < numBooks; i++) {
            if (catalog[i].getBookCode() == bookCode) {
                return catalog[i]; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }

    /**
     * Borrows a book from the library if it is available and borrowable.
     *
     * @param bookCode The code of the book to borrow.
     * @param quantity The quantity of books to borrow.
     * @return true if the book was borrowed successfully, false otherwise.
     */
    public boolean borrowBook(int bookCode, int quantity) {
        Book book = findBook(bookCode); // Find the book in the catalog
        if (book == null) {
            System.out.println("Code not found in catalog..."); // Inform if the code is not found
            return false; // Borrowing failed
        }
        if (!book.isBorrowable()) {
            System.out.println("This book is a reference book and cannot be borrowed."); // Inform if the book cannot be borrowed
            return false; // Borrowing failed
        }
        if (book.getQuantityInStock() < quantity) {
            System.out.println("Invalid quantity..."); // Inform if the quantity is invalid
            return false; // Borrowing failed
        }
        book.updateQuantity(-quantity); // Update the quantity in stock
        return true; // Successfully borrowed the book
    }

    /**
     * Returns a book to the library, updating the quantity in stock.
     *
     * @param bookCode The code of the book to return.
     * @param quantity The quantity of books to return.
     * @return true if the book was returned successfully, false otherwise.
     */
    public boolean returnBook(int bookCode, int quantity) {
        Book book = findBook(bookCode); // Find the book in the catalog
        if (book == null) {
            System.out.println("Code not found in catalog..."); // Inform if the code is not found
            return false; // Returning failed
        }
        book.updateQuantity(quantity); // Update the quantity in stock
        return true; // Successfully returned the book
    }
}
