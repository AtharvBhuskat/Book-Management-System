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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

/**
 * The BorrowReturnTests class contains unit tests for borrowing and returning books
 * in the Library system. It verifies the functionality of the borrow and return operations.
 */
public class BorrowReturnTests {
    private Library library; // Instance of Library to manage book operations
    private FictionBook fictionBook; // Fiction book instance
    private NonFictionBook nonFictionBook; // Non-fiction book instance
    private ReferenceBook referenceBook; // Reference book instance

    /**
     * Sets up the library and adds sample books before each test.
     */
    @BeforeEach
    public void setUp() {
        library = new Library(); // Initialize the Library

        // Add Fiction Book
        String fictionInput = "101\nFiction Book Title\nFiction Author\n10\n";
        ByteArrayInputStream fictionIn = new ByteArrayInputStream(fictionInput.getBytes());
        Scanner fictionScanner = new Scanner(fictionIn);
        fictionBook = new FictionBook();
        fictionBook.addBook(fictionScanner); // Add book details
        library.addBook(fictionBook); // Add to library

        // Add Non-Fiction Book
        String nonFictionInput = "102\nNon-Fiction Book Title\nNon-Fiction Author\n5\nScience\n";
        ByteArrayInputStream nonFictionIn = new ByteArrayInputStream(nonFictionInput.getBytes());
        Scanner nonFictionScanner = new Scanner(nonFictionIn);
        nonFictionBook = new NonFictionBook();
        nonFictionBook.addBook(nonFictionScanner); // Add book details
        library.addBook(nonFictionBook); // Add to library

        // Add Reference Book
        String referenceInput = "103\nReference Book Title\nReference Author\n3\n1st Edition\n";
        ByteArrayInputStream referenceIn = new ByteArrayInputStream(referenceInput.getBytes());
        Scanner referenceScanner = new Scanner(referenceIn);
        referenceBook = new ReferenceBook();
        referenceBook.addBook(referenceScanner); // Add book details
        library.addBook(referenceBook); // Add to library
    }

    /**
     * Tests successful borrowing of a book.
     */
    @Test
    public void testBorrowBookSuccess() {
        // Borrow 2 copies of the fiction book (success scenario)
        assertTrue(library.borrowBook(101, 2)); // Expect borrowing to succeed
        assertEquals(8, fictionBook.getQuantityInStock()); // Verify updated stock
    }

    /**
     * Tests borrowing a book with insufficient stock.
     */
    @Test
    public void testBorrowBookInsufficientStock() {
        // Try to borrow more copies than available (failure scenario)
        assertFalse(library.borrowBook(102, 10)); // Expect borrowing to fail
    }

    /**
     * Tests attempting to borrow a reference book.
     */
    @Test
    public void testBorrowReferenceBook() {
        // Try to borrow a reference book (should fail since they can't be borrowed)
        assertFalse(library.borrowBook(103, 1)); // Expect borrowing to fail
    }

    /**
     * Tests successful returning of a book.
     */
    @Test
    public void testReturnBookSuccess() {
        // Return 3 copies of the non-fiction book (success scenario)
        assertTrue(library.returnBook(102, 3)); // Expect returning to succeed
        assertEquals(8, nonFictionBook.getQuantityInStock()); // Verify updated stock
    }

    /**
     * Tests attempting to return a book that does not exist in the catalog.
     */
    @Test
    public void testReturnBookNonExistent() {
        // Try to return a book not in the catalog (failure scenario)
        assertFalse(library.returnBook(999, 1)); // Expect returning to fail
    }
}
