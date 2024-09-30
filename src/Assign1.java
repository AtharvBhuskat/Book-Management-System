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


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Assign1 class represents the main program for managing a library system.
 * It provides a menu-driven interface for users to interact with the library.
 */
public class Assign1 {

    /**
     * Displays the menu options to the user.
     */
    public static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Add Book to Library");
        System.out.println("2: Display Current Library Catalog");
        System.out.println("3: Borrow Book(s)");
        System.out.println("4: Return Book(s)");
        System.out.println("5: To Exit");
        System.out.print("> ");
    }

    /**
     * The main method that runs the library management program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        Library library = new Library(); // Instance of Library to manage books
        boolean exit = false; // Control variable for the main loop

        while (!exit) {
            displayMenu(); // Display the menu options
            try {
                int choice = scanner.nextInt(); // Read user's choice

                switch (choice) {
                    case 1: // Add a book
                        System.out.println("Do you wish to add a Fiction (f), Non-Fiction (n), or Reference (r) book?");
                        char type = scanner.next().charAt(0); // Read the book type
                        scanner.nextLine(); // Consume newline

                        Book newBook = null; // Initialize new book variable
                        switch (type) {
                            case 'f':
                                newBook = new FictionBook(); // Create a FictionBook instance
                                break;
                            case 'n':
                                newBook = new NonFictionBook(); // Create a NonFictionBook instance
                                break;
                            case 'r':
                                newBook = new ReferenceBook(); // Create a ReferenceBook instance
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid entry"); // Handle invalid book type
                        }
                        // Add the new book to the library if successful
                        if (newBook.addBook(scanner)) {
                            library.addBook(newBook);
                        }
                        break;
                    case 2: // Display the library catalog
                        System.out.println(library.toString());
                        break;
                    case 3: // Borrow a book
                        System.out.println("Enter book code to borrow: ");
                        int borrowCode = scanner.nextInt(); // Read the book code to borrow
                        System.out.println("Enter quantity to borrow: ");
                        int borrowQuantity = scanner.nextInt(); // Read the quantity to borrow
                        if (!library.borrowBook(borrowCode, borrowQuantity)) {
                            System.out.println("Borrowing operation failed."); // Handle borrowing failure
                        }
                        break;
                    case 4: // Return a book
                        System.out.println("Enter book code to return: ");
                        int returnCode = scanner.nextInt(); // Read the book code to return
                        System.out.println("Enter quantity to return: ");
                        int returnQuantity = scanner.nextInt(); // Read the quantity to return
                        if (!library.returnBook(returnCode, returnQuantity)) {
                            System.out.println("Return operation failed."); // Handle return failure
                        }
                        break;
                    case 5: // Exit the program
                        System.out.println("Exiting...");
                        exit = true; // Set exit flag to true
                        break;
                    default:
                        System.out.println("Incorrect value entered"); // Handle invalid choice
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter numbers where applicable."); // Handle input mismatch
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Handle illegal argument exception
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage()); // Handle unexpected exceptions
            }
        }
        scanner.close(); // Close the scanner
    }
}
