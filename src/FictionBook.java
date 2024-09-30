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
 * The FictionBook class represents a type of Book specifically categorized as Fiction.
 * It extends the Book class and inherits its properties and methods, with 
 * additional behavior specific to Fiction books.
 */
public class FictionBook extends Book {

    /**
     * Default constructor for FictionBook.
     * It sets the genre of the book to "Fiction".
     */
    public FictionBook() {
        this.genre = "Fiction"; // Sets the genre to Fiction
    }

    /**
     * Returns a string representation of the FictionBook object.
     * This method overrides the toString method from the Book class.
     *
     * @return A string containing the book's details, using the toString method from the superclass (Book).
     */
    @Override
    public String toString() {
        return super.toString(); // Call the superclass's toString method
    }

    /**
     * Prompts the user to add details for the FictionBook.
     * This method overrides the addBook method from the Book class.
     *
     * @param scanner The Scanner object used to gather user input.
     * @return true after successfully adding the book details, including setting the genre to "Fiction".
     */
    @Override
    public boolean addBook(Scanner scanner) {
        super.addBook(scanner); // Calls the Book class's addBook method to gather common details
        this.genre = "Fiction"; // Sets the genre to Fiction
        return true; // Return true after successfully adding the book
    }
}
