package com.lambton;
/**
 * Simulation for a publications system that can save the Book/Article title
 * and the number of available copies
 *
 * @author  Omairys Uzcategui
 * @version 1.0
 * @since   2021-07-20
 */

public class Book extends Publication{
    private double price;
    private String publisher;
    private int numOfCopies;
    static double PERCENT = 0.20;

    public Book(int number, String title, String name, String lastName, double price, String publisher, int numOfCopies) {
        super(number, title, name, lastName);
        this.price = price;
        this.publisher = publisher;
        this.numOfCopies = numOfCopies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    @Override
    public double calcIncome() {
        double earnings = price * numOfCopies;
        return earnings - (earnings * PERCENT);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Book{" +
                "price=" + price +
                ", publisher='" + publisher + '\'' +
                ", numOfCopies=" + numOfCopies +
                '}';
    }
}
