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
 * The ReferenceBook class represents a type of Book categorized as Reference.
 * It extends the Book class and includes an additional field for the edition of the book.
 */
public class ReferenceBook extends Book {
    // The edition of the Reference book
    private String edition;

    /**
     * Default constructor for ReferenceBook.
     * It sets the genre of the book to "Reference".
     */
    public ReferenceBook() {
        this.genre = "Reference"; // Sets the genre to Reference
    }

    /**
     * Returns a string representation of the ReferenceBook object.
     * This method overrides the toString method from the Book class and adds
     * the edition information to the returned string.
     *
     * @return A string containing the book's details, including its edition.
     */
    @Override
    public String toString() {
        return super.toString() + " Edition: " + edition; // Append the edition to the string
    }

    /**
     * Prompts the user to add details for the ReferenceBook, including the edition.
     * This method overrides the addBook method from the Book class.
     *
     * @param scanner The Scanner object used to gather user input.
     * @return true after successfully adding the book details and edition.
     */
    @Override
    public boolean addBook(Scanner scanner) {
        super.addBook(scanner); // Calls the Book class's addBook method to gather common details
        System.out.println("Enter the edition of the book: ");
        scanner.nextLine(); // Consume newline
        edition = scanner.nextLine(); // Capture the edition input from the user
        return true; // Return true after successfully adding the book
    }

    /**
     * Determines if the ReferenceBook is borrowable.
     * This method overrides the isBorrowable method from the Book class.
     *
     * @return false, indicating that reference books cannot be borrowed.
     */
    @Override
    public boolean isBorrowable() {
        return false;  // Reference books cannot be borrowed
    }
}
