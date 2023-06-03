/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package net.codejava.librarymanagement;

import java.util.Scanner;

/**
 *
 * @author valpib
 */
public class LibraryManagement {
private static final int ADD_BOOK = 1;
    private static final int REMOVE_BOOK = 2;
    private static final int DISPLAY_ALL_BOOKS = 3;
    private static final int ADD_PATRON = 4;
    private static final int REMOVE_PATRON = 5;
    private static final int DISPLAY_ALL_PATRONS = 6;
    private static final int CHECK_OUT_BOOK = 7;
    private static final int RETURN_BOOK = 8;
    private static final int DISPLAY_CHECKED_OUT_BOOKS = 9;
    private static final int DISPLAY_ALL_LOANS = 10;
    private static final int EXIT = 11;

    public static void main(String[] args) {
        int choice = 0;
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (choice != EXIT) {
            
            displayMenu();
            System.out.print("Enter your choice: ");
            Scanner getChoice = new Scanner(System.in); // creating a scanner to take user input
            String selectChoice = getChoice.nextLine();

            //validating data if user put blank value or alphanumeric value
            while(selectChoice.equals("") ||!isStringNumeric(selectChoice))
            {
                System.out.println("\nERROR - Book selection cannot be blank or string value.");
                System.out.println("Please select the menu number correctly. ");
                System.out.print("Enter your choice: ");
                selectChoice = getChoice.nextLine();
            }
            
            choice = Integer.parseInt(selectChoice);
            switch (choice) {
                case ADD_BOOK:
                    addBook(library, scanner);
                    break;
                case REMOVE_BOOK:
                    removeBook(library, scanner);
                    break;
                case DISPLAY_ALL_BOOKS:
                    library.displayAllBooks();
                    break;
                case ADD_PATRON:
                    addPatron(library, scanner);
                    break;
                case REMOVE_PATRON:
                    removePatron(library, scanner);
                    break;
                case DISPLAY_ALL_PATRONS:
                    library.displayAllPatrons();
                    break;
                case CHECK_OUT_BOOK:
                    checkOutBook(library, scanner);
                    break;
                case RETURN_BOOK:
                    returnBook(library, scanner);
                    break;
                case DISPLAY_CHECKED_OUT_BOOKS:
                    library.displayCheckedOutBooks();
                    break;
                case DISPLAY_ALL_LOANS:
                    library.displayAllLoans();
                    break;
                case EXIT:
                    System.out.println("Thank you for using the application.");
                    System.out.println(" *** Have a good one!! ***");
                    System.out.println("   *** See you soon. ***");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
    //method to display the library menu with certain functionalities
    private static void displayMenu() {
        System.out.println("Library Menu");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Display All Books");
        System.out.println("4. Add Patron");
        System.out.println("5. Remove Patron");
        System.out.println("6. Display All Patrons");
        System.out.println("7. Check Out Book");
        System.out.println("8. Return Book");
        System.out.println("9. Display Checked Out Books");
        System.out.println("10. Display All Loans");
        System.out.println("11. Exit");
        
    }
    private static boolean isStringNumeric(String str)
	{
            //using for loop to read the character according to the length of the data
            for (int i = 0; i < str.length(); i++)
            {
                //using if condition to check data is digit
                if (!Character.isDigit(str.charAt(i)))
                        return false; // returns the value (false) to the method which call this method
            }

            return true; // returns the value (true) to the method which call this method
	}
    
    //method to add book in the library
    private static void addBook(Library library, Scanner scanner) {
        boolean check = false;
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        while(title.equals("") ||isStringNumeric(title))
            {
                System.out.println("\nERROR - Book title cannot be blank or numeric value.");
                System.out.print("Enter the book title: ");
                title = scanner.nextLine();
            }
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
       while(author.equals("") ||isStringNumeric(author))
            {
                System.out.println("\nERROR - Book author cannot be blank or numeric value.");
                System.out.print("Enter the book title: ");
                author = scanner.nextLine();
            }
        for( Book book: library.getBooks())
        {
            if(book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)){
                System.out.println("\n         *** SORRY!!! ***");
                System.out.println("The book you are trying to enter cannot be added.");
                System.out.println("The book with same author and title is already in the Library");
                check = true;
                break;
            }   
        }
        if (check == false){
            System.out.print("Enter the book ISBN: ");
            String isbn = scanner.nextLine();
            while(isbn.equals(""))
            {
                System.out.println("\nERROR - Book ISBN cannot be blank.");
                System.out.print("Enter the book ISBN: ");
                isbn = scanner.nextLine();
            }
            System.out.print("Enter the number of copies available: ");
            String copiesAvailable1 = scanner.nextLine();
            while(copiesAvailable1.equals("") ||!isStringNumeric(copiesAvailable1))
            {
                System.out.println("\nERROR - Number of copies cannot be blank or string value.");
                System.out.print("Enter the number of copies available: ");
                copiesAvailable1 = scanner.nextLine();
            }
            int copiesAvailable = Integer.parseInt(copiesAvailable1);           
            Book book = new Book(title, author, isbn, copiesAvailable);
            library.addBook(book);   
        }
   
    }
   //method to remove the book from the library
    private static void removeBook(Library library, Scanner scanner) {
        int count = 0;
        for( Book book: library.getBooks())
        {
            count ++;
            
        }
        if (count > 0){
            // to print all the books available to ease user in selecting book to remove
            int countCheckBook = 1;
            System.out.println("\n *** Books information *** ");
            for (Book book : library.getBooks()) {
                System.out.println("Book no."+countCheckBook);
                book.displayInfo();
                countCheckBook ++;
                System.out.println();
            }
            //asking user a input for the book to remove
            System.out.print("Enter the book title to remove: ");
            String title = scanner.nextLine();

            //to store the book in bookRemove object if the book does exist in library else store null in bookRemove object
            Book bookToRemove = null;
            for (Book book : library.getBooks()) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    bookToRemove = book;
                    break;
                }
            }

            // to check whether the book given by user does match with the book in the library to checkout
            if (bookToRemove != null) {
                //to check whether the book is already checked out or not
                //if does then the book cannot be removed from the library
                if (bookToRemove.isCheckedOut()) {
                    System.out.println("Cannot remove the book as it is currently checked out.");
                } else {
                    library.removeBook(bookToRemove);
                }
            } else {
                System.out.println("Book '" + title + "' not found in the library.");
            }
        }
        else
        {
             System.out.println("\n         *** SORRY!!! ***");
            System.out.println("There are no any books to remove.");
        }
    }

    //method to add patron in the library system
    private static void addPatron(Library library, Scanner scanner) {
        System.out.print("Enter the patron name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the patron ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Patron patron = new Patron(name, id);
        library.addPatron(patron);
    }

    //method to remove patron from the library
    private static void removePatron(Library library, Scanner scanner) {
        int count = 0;
        for (Patron patron : library.getPatrons()) {
            count ++;
        }
        if (count > 0) 
        {
            int countCheckPatron = 1;
            System.out.println("\n *** Patron information ***");
            for (Patron patron : library.getPatrons()) {
                System.out.println("Patron no."+countCheckPatron);
                patron.displayInfo();
                countCheckPatron++;
                System.out.println();
            }

            System.out.print("Enter the patron ID to remove: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // to find the patron by ID if exists else store null in partronToRemove object
            Patron patronToRemove = null;
            for (Patron patron : library.getPatrons()) {
                if (patron.getId() == id) {
                    patronToRemove = patron;
                    break;
                }
            }
            //to check the patron entered by user does exists in the library system or not
            if (patronToRemove != null) {
                //to check the certain patron has checked out books or not
                if (patronToRemove.getCheckedOutBooks()!= null){
                    System.out.println("\n         *** SORRY!!! ***");
                    System.out.println("Cannot remove Patron because the patron has currently checked out books.");
                }
                else{
                library.removePatron(patronToRemove);
                }
            } else {
                System.out.println("Patron with ID " + id + " not found in the library.");
            }
        }
        else
        {
             System.out.println("\n         *** SORRY!!! ***");
             System.out.println("There are no any Patron in the Library to remove. ");
        }
    }

    //method to checkout book from the library
    private static void checkOutBook(Library library, Scanner scanner) {
        
        int count = 0;
        int count1 = 0;
        for (Patron patron : library.getPatrons()) {
            count ++;
        }
        for( Book book: library.getBooks())
        {
            count1++;
        }
        if (count1 > 0)
        {
            if (count > 0)
            {

                int countCheckBook = 1;

                //printing all the books from library to ease user to select the books
                System.out.println("\n *** Books information *** ");
                for (Book book : library.getBooks()) {
                    System.out.println("Book no."+countCheckBook);
                    book.displayInfo();
                    countCheckBook ++;
                    System.out.println();
                }

                System.out.print("Enter the book title to check out: ");
                String title = scanner.nextLine();

                // to find the book by title if exists on library else store null value on bookToCheckOut object
                Book bookToCheckOut = null;
                for (Book book : library.getBooks()) {
                    if (book.getTitle().equalsIgnoreCase(title)) {
                        bookToCheckOut = book;
                        break;
                    }
                }

                //to check whether the book entered by user exists in library or not
                if (bookToCheckOut != null) {

                    //to print all the patron details to ease the user to select the patron
                    int countCheckPatron = 1;
                    System.out.println("\n *** Patron information ***");
                    for (Patron patron : library.getPatrons()) {
                    System.out.println("Patron no."+countCheckPatron);
                    patron.displayInfo();
                    countCheckPatron++;
                    System.out.println();
                    }

                    System.out.print("Enter the patron ID to check out the book: ");
                    int patronId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    // to find the patron by ID if exists in the library else the patron object will get null value by default
                    Patron patron = null;
                    for (Patron p : library.getPatrons()) {
                        if (p.getId() == patronId) {
                            patron = p;
                            break;
                        }
                    }

                    //to check the patron selected by user matches the patron in the library
                    //if does then patron will check out the selected book
                    if (patron != null) {
                        library.checkOutBook(bookToCheckOut, patron);
                    } else {
                        System.out.println("Patron with ID " + patronId + " not found in the library.");
                    }
                } else {
                    System.out.println("Book '" + title + "' not found in the library.");
                }   
            }
            else
            {
                 System.out.println("\n         *** SORRY!!! ***");
                 System.out.println(" The Library does not have any patrons to check out books.");
            }
        }
        else
        {
            System.out.println("\n         *** SORRY!!! ***"); 
            System.out.println(" The Library does not have any books to check out.");
        }
     
    }

    private static void returnBook(Library library, Scanner scanner) {
         int check1 = 0;
         boolean check = false;
         
        for (Book book : library.getBooks()) {
            check1++;
        }
        if (check1 > 0)
        {
            for (Book book : library.getBooks()) {
                if(book.isCheckedOut() == true)
                {
                    check = true;
                    break;
                }
              
            }
            if(check == true)
            {
                int countCheckBook = 1;
                //to print all the books to ease the user in selecting the book to return
                System.out.println("\nBooks information: ");
                for (Book book : library.getBooks()) {
                    System.out.println("Book no."+countCheckBook);
                    book.displayInfo();
                    countCheckBook ++;
                    System.out.println();
                }

                System.out.print("Enter the book title to return: ");
                String title = scanner.nextLine();

                // to find the book by title if exists in the library else bookToReturn object will have null value
                Book bookToReturn = null;
                for (Book book : library.getBooks()) {
                    if (book.getTitle().equalsIgnoreCase(title)) {
                        bookToReturn = book;
                        break;
                    }
                }

                //check if the user selected the book that exists in the library else print the selected book not found
                if (bookToReturn != null) {
                     int countCheckPatron = 1;
                    // to print all the patron's information from the library to ease the user in selecting the patron to return book
                    System.out.println("\n *** Patron information ***");
                    for (Patron patron : library.getPatrons()) {
                        System.out.println("Patron no."+countCheckPatron);
                        patron.displayInfo();
                        countCheckPatron++;
                        System.out.println();
                    }

                    System.out.print("Enter the patron ID to return the book: ");
                    int patronId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    // to find the patron by ID if exists in the library or store null value in patron object by default
                    Patron patron = null;
                    for (Patron p : library.getPatrons()) {
                        if (p.getId() == patronId) {
                            patron = p;
                            break;
                        }
                    }

                    //to check the selected patron does exists in the library ro return the selected book else print patron not found
                    if (patron != null) {
                        library.returnBook(bookToReturn, patron);
                    } else {
                        System.out.println("Patron with ID " + patronId + " not found in the library.");
                    }
                } 
                else {
                    System.out.println("Book '" + title + "' not found in the library.");
                }
            }
            else
            {
                 System.out.println("  \n       *** SORRY!!! ***"); 
                 System.out.println("No patrons have taken the book to return.");
            }
        }
        else
        {
            System.out.println("\n         *** SORRY!!! ***"); 
            System.out.println("The Library should have a book in the first place.");
            System.out.println("So, no patrons have taken any book to return.");
        }

    }
}
