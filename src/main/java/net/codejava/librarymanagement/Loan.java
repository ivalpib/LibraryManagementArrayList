/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.librarymanagement;

import java.time.LocalDate;

/**
 *
 * @author valpib
 */
public class Loan {
    //initialising the private variables for the Loan class
    private Book book;
    private Patron patron;
    private LocalDate dueDate;

    //parameterised constructor of the Loan class
    public Loan(Book book, Patron patron, LocalDate dueDate) {
        this.book = book;
        this.patron = patron;
        this.dueDate = dueDate;
    }

    //method to get book
    public Book getBook() {
        return book;
    }

    //method to get patron 
    public Patron getPatron() {
        return patron;
    }

    //method to get due date
    public LocalDate getDueDate() {
        return dueDate;
    }

    //method to calculate the due date
    public double calculateOverdueFees() {
        LocalDate currentDate = LocalDate.now();
        //checking whether the current date over the due date to calculate due amount
        if (currentDate.isAfter(dueDate)) {
            long daysOverdue = currentDate.toEpochDay() - dueDate.toEpochDay();
            return daysOverdue * 1; //  the program assumed the overdue fee is $1 per day
        }
        return 0.0;
    }

    //method to display loan information
    public void displayInfo() {
        System.out.println("Loan Information:");
        System.out.println("Book: " + book.getTitle());
        System.out.println("Patron: " + patron.getName());
        System.out.println("Due Date: " + dueDate);
        double overdueFees = calculateOverdueFees();
        if (overdueFees > 0.0) {
            System.out.println("Overdue Fees: $" + overdueFees);
        } else {
            System.out.println("No overdue fees.");
        }
    }
}
   