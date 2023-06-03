/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.librarymanagement;

/**
 *
 * @author valpib
 */
public class Book {
     
    //initialising required private variable for the Book class
    private String title;
    private String author;
    private String isbn;
    private int copiesAvailable;
    private boolean checkedOut = false;

    //parameterised constructor of Book Class
    public Book(String title, String author, String isbn, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copiesAvailable = copiesAvailable;
    }

    //method to get title of the book
    public String getTitle() {
        return title;
    }

    //method to get author of the book
    public String getAuthor() {
        return author;
    }

    //method ot get ISBN of the book
    public String getIsbn() {
        return isbn;
    }

    //method to get copies that are available in the library of the book
    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    //method to check out the book
    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            checkedOut = true;
        } else {
            System.out.println("Book '" + title + "' is not available for checkout.");
        }
    }

    //method to return the book 
    public void returnBook() {
        copiesAvailable++;
        System.out.println("Book '" + title + "' has been returned.");
    }

    //using this method if the certain book has been checked out or not
    public boolean isCheckedOut() {
        return checkedOut;
    }
    
    //method to display all the information of the certain books
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Copies Available: " + copiesAvailable);
    }
    
}
