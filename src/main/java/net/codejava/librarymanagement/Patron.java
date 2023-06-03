/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.librarymanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valpib
 */
public class Patron {
    //initialising the required private variables of the Patron class
    private String name;
    private int id;
    
    //creating checkOutBooks object of the Book class
    private List<Book> checkedOutBooks;

    //parameterised constructor of Patron Class
    public Patron(String name, int id) {
        this.name = name;
        this.id = id;
        this.checkedOutBooks = new ArrayList<>();
    }

    //method to get name of the patron
    public String getName() {
        return name;
    }

    //method to get ID of the patron
    public int getId() {
        return id;
    }

    // method to get checked out books by certain patron
    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    //method to check out the book 
    public void checkOutBook(Book book) {
        checkedOutBooks.add(book);
        System.out.println("Book '" + book.getTitle() + "' has been checked out by " + name);
    }

    //method to return the book
    public void returnBook(Book book) {
        if (checkedOutBooks.remove(book)) {
            System.out.println("Book '" + book.getTitle() + "' has been returned by " + name);
        } else {
            System.out.println("Book '" + book.getTitle() + "' was not checked out by " + name);
        }
    }

    //method to display information of the patron
    public void displayInfo() {
        System.out.println("Patron Information:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Books Checked Out: " + checkedOutBooks.size());
        for (Book book : checkedOutBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
    
}
