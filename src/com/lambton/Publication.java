package com.lambton;
/**
 * Simulation for a publications system that can save the Book/Article title
 * and the number of available copies
 *
 * @author  Omairys Uzcategui
 * @version 1.0
 * @since   2021-07-20
 */
public abstract class Publication {
    private int number;
    private String title;
    private String name;
    private String lastName;

    public Publication(int number, String title, String name, String lastName) {
        this.number = number;
        this.title = title;
        this.name = name;
        this.lastName = lastName;
    }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return name +" "+ lastName; }

    public abstract double calcIncome();

    @Override
    public String toString() {
        return "Publication{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + name +" "+ lastName + '\'' +
                '}';
    }
}
