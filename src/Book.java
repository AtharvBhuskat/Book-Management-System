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

import java.util.Scanner;

/**
 * The Book class represents a book with basic details such as 
 * book code, title, author, genre, and quantity in stock.
 * It also provides methods to manage the book's inventory 
 * and determine its borrowable status.
 */
public class Book {
    // Private instance variables
    private int bookCode;
    private String title;
    private String author;
    protected String genre; // Protected for subclass access
    private int quantityInStock;

    /**
     * Default constructor.
     */
    public Book() {}

    /**
     * Parameterized constructor to initialize a book with its details.
     * 
     * @param bookCode        The unique code of the book.
     * @param title           The title of the book.
     * @param author          The author of the book.
     * @param genre           The genre of the book.
     * @param quantityInStock The quantity of the book available in stock.
     */
    public Book(int bookCode, String title, String author, String genre, int quantityInStock) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Returns a string representation of the book object, including 
     * its book code, title, author, genre, and the quantity in stock.
     *
     * @return A string containing the book's details.
     */
    public String toString() {
        return "Book: " + bookCode + " " + title + " " + quantityInStock + " Author: " + author + " Genre: " + genre;
    }

    /**
     * Updates the quantity of the book in stock by a specified amount.
     * The operation fails if the new quantity would be negative.
     *
     * @param amount The amount by which to update the quantity.
     * @return true if the quantity is successfully updated, false if the operation would result in a negative stock.
     */
    public boolean updateQuantity(int amount) {
        if (quantityInStock + amount < 0) return false; // Prevent negative stock
        quantityInStock += amount; // Update stock quantity
        return true;
    }

    /**
     * Compares two books based on their title and author.
     *
     * @param book The book to compare with.
     * @return true if both books have the same title and author, false otherwise.
     */
    public boolean isEqual(Book book) {
        return this.title.equals(book.title) && this.author.equals(book.author);
    }

    /**
     * Adds a book by prompting the user for its details using the Scanner.
     *
     * @param scanner The Scanner object to read input from.
     * @return true after successfully adding the book.
     */
    public boolean addBook(Scanner scanner) {
        // Prompt and collect input for book code
        System.out.println("Enter the code for the book: ");
        bookCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Prompt and collect input for book title
        System.out.println("Enter the title of the book: ");
        title = scanner.nextLine();

        // Prompt and collect input for book author
        System.out.println("Enter the author of the book: ");
        author = scanner.nextLine();

        // Prompt and collect input for book quantity
        System.out.println("Enter the quantity of the book: ");
        quantityInStock = scanner.nextInt();

        return true;
    }

    /**
     * Gets the book code.
     *
     * @return The code of the book.
     */
    public int getBookCode() {
        return bookCode;
    }

    /**
     * Gets the quantity of the book in stock.
     *
     * @return The quantity of the book available in stock.
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Sets the quantity of the book in stock.
     *
     * @param quantity The new quantity of the book.
     */
    public void setQuantityInStock(int quantity) {
        this.quantityInStock = quantity;
    }

    /**
     * Determines if the book is borrowable.
     * By default, all books are borrowable unless specified otherwise by subclasses.
     *
     * @return true if the book is borrowable, false otherwise.
     */
    public boolean isBorrowable() {
        return true;  // By default, books are borrowable
    }
}
