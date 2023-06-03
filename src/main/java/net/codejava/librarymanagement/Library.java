/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.librarymanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valpib
 */
public class Library {
    //creating required objects of the required class
    private List<Book> books;
    private List<Patron> patrons;
    private List<Loan> loans;
   

    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    //method to add the book in the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' has been added to the library successfully.");
    }

    //method to remove the book from the library
    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book '" + book.getTitle() + "' has been removed from the library successfully.");
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not found in the library.");
        }
    }

    //method to display all the books and its informations
    public void displayAllBooks() {
        if (books.isEmpty())
        {
             System.out.println("\n         *** SORRY!!! ***");
             System.out.println("There are no any books to display.");
        }
        else
        {
            System.out.println("\n *** Books in the Library ***");
            for (Book book : books) {
                book.displayInfo();
                System.out.println();
            }
        }
    }

    //method to add patron in the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron '" + patron.getName() + "' has been added to the library  successfully .");
    }

    //method to remove patron from the library
    public void removePatron(Patron patron) {
        if (patrons.remove(patron)) {
            System.out.println("Patron '" + patron.getName() + "' has been removed from the library successfully.");
        } else {
            System.out.println("Patron '" + patron.getName() + "' is not found in the library.");
        }
    }

    
    //method to display all the patrons that exists in the library
    public void displayAllPatrons() {
        if (patrons.isEmpty())
        {
             System.out.println("\n         *** SORRY!!! ***");
             System.out.println("There are no any Patrons to display.");
        }
        else
        {
            System.out.println("\n *** Patrons in the Library ***");
            for (Patron patron : patrons) {
                patron.displayInfo();
                System.out.println();
            }
        }
        
    }

    //method to check out book 
    public void checkOutBook(Book book, Patron patron) {
        if (books.contains(book) && patrons.contains(patron)) {
            if (book.getCopiesAvailable() > 0) {
                book.checkOut();
                patron.checkOutBook(book);
                loans.add(new Loan(book, patron, LocalDate.now().plusWeeks(1))); // lets assume the patron can take book for 1 week 
            } else {
                System.out.println("Book '" + book.getTitle() + "' is not available for checkout.");
            }
        } else {
            System.out.println("Book or patron not found in the library.");
        }
    }

    //method to return the book to the library
    public void returnBook(Book book, Patron patron) {
        if (books.contains(book) && patrons.contains(patron)) {
            patron.returnBook(book);
            book.returnBook();
            loans.removeIf(loan -> loan.getBook().equals(book) && loan.getPatron().equals(patron));
        } else {
            System.out.println("Book or patron not found in the library.");
        }
    }

    //method to display all the checked out books 
    public void displayCheckedOutBooks() {
        int check = 0;
        if(!books.isEmpty())
        {
            for (Loan loan : loans) {
            Book book = loan.getBook();
                check ++;
            }
            if (check > 0)
            {
                System.out.println("\n*** Checked Out Books ***");
               for (Loan loan : loans) {
                   loan.getBook().displayInfo();
                   System.out.println("Checked out by: " + loan.getPatron().getName());
                   System.out.println("Due Date: " + loan.getDueDate());
                   System.out.println();
                }
            }
            else
            {
                System.out.println("\n         *** SORRY!!! ***");
                System.out.println("There is no any book checked out.");
            }
            
        }
        else
        {
            System.out.println("\n         *** SORRY!!! ***");
            System.out.println("Library does not have books to check out in the first place.");
        }
        
       
    }

    //method to display all the loans
    public void displayAllLoans() {
        int check = 0;
        for (Loan loan : loans) {
            Book book = loan.getBook();
                check ++;
            }
        if (check > 0)
        {
           System.out.println("\n *** All Loans ***");
            for (Loan loan : loans) {
                loan.displayInfo();
                System.out.println();
            } 
        }
        else
        {
             System.out.println("\n         *** SORRY!!! ***");
             System.out.println("There are no any loans at the moment.");
        }
        
    }

    //method to ietrate the books object stored in Book 
    public Iterable<Book> getBooks() {
        return books;
    }
    
    //method to iterate the patrons object store in Patron so that the 
    public Iterable<Patron> getPatrons() {
        return patrons;
    }

    
}
