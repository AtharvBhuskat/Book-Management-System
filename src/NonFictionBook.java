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
 * The NonFictionBook class represents a type of Book categorized as Non-Fiction.
 * It extends the Book class and adds a specific field for the subject or field of study.
 */
public class NonFictionBook extends Book {
    // The field of study or subject of the Non-Fiction book
    private String fieldOfStudy;

    /**
     * Default constructor for NonFictionBook.
     * It sets the genre of the book to "Non-Fiction".
     */
    public NonFictionBook() {
        this.genre = "Non-Fiction"; // Sets the genre to Non-Fiction
    }

    /**
     * Returns a string representation of the NonFictionBook object.
     * This method overrides the toString method from the Book class and adds
     * the field of study to the returned string.
     *
     * @return A string containing the book's details, including its field of study.
     */
    @Override
    public String toString() {
        return super.toString() + " Field of Study: " + fieldOfStudy; // Append the field of study
    }

    /**
     * Prompts the user to add details for the NonFictionBook, including the field of study.
     * This method overrides the addBook method from the Book class.
     *
     * @param scanner The Scanner object used to gather user input.
     * @return true after successfully adding the book details and field of study.
     */
    @Override
    public boolean addBook(Scanner scanner) {
        super.addBook(scanner); // Calls the Book class's addBook method to gather common details
        System.out.println("Enter the field of study: ");
        scanner.nextLine(); // Consume newline
        fieldOfStudy = scanner.nextLine(); // Capture the field of study input from the user
        return true; // Return true after successfully adding the book
    }
}
